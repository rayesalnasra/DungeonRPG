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
public class GameSaverLoader {
    
    private static Connection connect() throws SQLException {
        String url = "jdbc:derby:DungeonRPGDatabase;create=true"; // Adjust the URL as needed
        return DriverManager.getConnection(url);
    }
    
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
}
