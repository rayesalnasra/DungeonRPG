/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DungeonRPG;

import java.io.*;
import java.sql.*;

/**
 *
 * @author rayesa
 */

/**
 * The GameSaverLoader class handles the saving, loading, and deleting
 * of game states for the DungeonRPG game. It interacts with a Derby
 * database to persist game data.
 */
public class GameSaverLoader {
    
    /**
     * Establishes a connection to the Derby database.
     * 
     * @return a Connection object connected to the database
     * @throws SQLException if a database access error occurs
     */    
    private static Connection connect() throws SQLException {
        // URL for connecting to the Derby database
        String url = "jdbc:derby:DungeonRPGDatabase;create=true"; // Adjust the URL as needed
        return DriverManager.getConnection(url);
    }

    /**
     * Saves the current game state to the database.
     * 
     * @param game the TextAdventure game object to save
     */
    public static void saveGame(TextAdventure game) {
        try (Connection conn = connect()) {
            conn.setAutoCommit(false);  // Start transaction

            // Ensure the tables exist
            try (Statement stmt = conn.createStatement()) {
                String createGameTable = "CREATE TABLE GameState (id INT PRIMARY KEY, game BLOB)";
                String createInventoryTable = "CREATE TABLE PlayerInventory (id INT PRIMARY KEY, inventory BLOB)";
                stmt.executeUpdate(createGameTable);
                stmt.executeUpdate(createInventoryTable);
            } catch (SQLException e) {
                // Handle case where tables already exist
                if (!e.getSQLState().equals("X0Y32")) {
                    throw e;
                }
            }

            // Serialize the game object
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
                oos.writeObject(game);
            }

            // Update the game state in the database
            String updateGame = "UPDATE GameState SET game = ? WHERE id = 1";
            try (PreparedStatement pstmt = conn.prepareStatement(updateGame)) {
                pstmt.setBytes(1, baos.toByteArray());
                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected == 0) {
                    String insertGame = "INSERT INTO GameState (id, game) VALUES (1, ?)";
                    try (PreparedStatement pstmtInsert = conn.prepareStatement(insertGame)) {
                        pstmtInsert.setBytes(1, baos.toByteArray());
                        pstmtInsert.executeUpdate();
                    }
                }
            }

            conn.commit();  // Commit transaction

            System.out.println("Game has saved successfully!");
        } catch (SQLException | IOException e) {
            // Handle any exceptions that occur during the save process
            System.out.println("There has been an error, the game failed to save");
            System.out.println(e.getClass() + ": " + e.getMessage());
        }
    }

    /**
     * Loads the game state from the database.
     * 
     * @return the loaded TextAdventure game object, or null if no saved game is found
     */
    public static TextAdventure loadGame() {
        TextAdventure loadedGame = null;
        try (Connection conn = connect()) {
            // Retrieve the game state from the database
            String selectGame = "SELECT game FROM GameState WHERE id = 1";
            try (PreparedStatement pstmt = conn.prepareStatement(selectGame);
                 ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    byte[] gameData = rs.getBytes("game");
                    try (ByteArrayInputStream bais = new ByteArrayInputStream(gameData);
                         ObjectInputStream ois = new ObjectInputStream(bais)) {
                        loadedGame = (TextAdventure) ois.readObject();
                        System.out.println("Game has loaded successfully!");
                    }

                    // Load the player inventory
                    PlayerManager playerManager = new PlayerManager(loadedGame);
                    playerManager.loadInventory();
                } else {
                    System.out.println("No game state found in the database.");
                }
            }
        } catch (SQLException | IOException | ClassNotFoundException e) {
            // Handle any exceptions that occur during the load process
            System.out.println("There has been an error, the game failed to load");
            System.out.println(e.getClass() + ": " + e.getMessage());
        }
        return loadedGame;
    }

    /**
     * Checks if a game save exists in the database.
     * 
     * @return true if a game save exists, false otherwise
     */
    public static boolean doesGameSaveExist() {
        boolean gameSaveExists = false;
        TextAdventure loadedGame = null;
        try (Connection conn = connect()) {
            // Retrieve the game state from the database
            String selectGame = "SELECT game FROM GameState WHERE id = 1";
            try (PreparedStatement pstmt = conn.prepareStatement(selectGame);
                 ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    gameSaveExists = true;
                    byte[] gameData = rs.getBytes("game");
                    try (ByteArrayInputStream bais = new ByteArrayInputStream(gameData);
                         ObjectInputStream ois = new ObjectInputStream(bais)) {
                        loadedGame = (TextAdventure) ois.readObject();
                        System.out.println("Game has loaded successfully!");
                    }

                    // Load the player inventory
                    PlayerManager playerManager = new PlayerManager(loadedGame);
                    playerManager.loadInventory();
                } else {
                    System.out.println("No game state found in the database.");
                }
            }
        } catch (SQLException | IOException | ClassNotFoundException e) {
            // Handle any exceptions that occur during the load process
            System.out.println("There has been an error, the game failed to load");
            System.out.println(e.getClass() + ": " + e.getMessage());
        }
        return gameSaveExists;
    }

    /**
     * Deletes the game save from the database.
     * 
     * @return true if the game save was deleted successfully, false otherwise
     */
    public static boolean deleteGameSave() {
        try (Connection conn = connect()) {
            conn.setAutoCommit(false);  // Start transaction

            // Delete the game state from the database
            String deleteGame = "DELETE FROM GameState WHERE id = 1";
            try (PreparedStatement pstmt = conn.prepareStatement(deleteGame)) {
                pstmt.executeUpdate();
            }

            // Delete the player inventory from the database
            String deleteInventory = "DELETE FROM PlayerInventory WHERE id = 1";
            try (PreparedStatement pstmt = conn.prepareStatement(deleteInventory)) {
                pstmt.executeUpdate();
            }

            conn.commit();  // Commit transaction
            return true;
        } catch (SQLException e) {
            System.out.println("There has been an error, the game save failed to delete");
            System.out.println(e.getClass() + ": " + e.getMessage());
            return false;
        }
    }

}
