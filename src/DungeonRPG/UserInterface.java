package DungeonRPG;
import java.sql.Connection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.ByteArrayOutputStream;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rayesa
 */

/**
 * The UserInterface class is responsible for handling user input and output
 * for the text adventure game.
 */
public class UserInterface {
    private static TextAdventure game;
    
    private static Connection connect() throws SQLException {
        String url = "jdbc:derby:DungeonRPGDatabase;create=true";
        return DriverManager.getConnection(url);
    }
    // Saves the current game state to a file.
//    private static void saveGame() {
//        try {
//            // Create a new file output stream to write the game object
//            FileOutputStream fileOutputStream = new FileOutputStream("Adv.sav");
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//
//            // Write the current game object to the file
//            objectOutputStream.writeObject(game);
//            objectOutputStream.flush(); // Ensure all data is written to the file
//            objectOutputStream.close(); // Close the output stream
//
//            System.out.println("Game has saved successfully!");
//
//            // Check if PlayerInventory.sav exists
//            File playerInventorySave = new File("PlayerInventory.sav");
//            if (playerInventorySave.exists()) {
//                // If PlayerInventory.sav exists, create a copy called PlayerInventorySaved.sav
//                File playerInventorySaved = new File("PlayerInventorySaved.sav");
//                Files.copy(playerInventorySave.toPath(), playerInventorySaved.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            }
//        } catch (Exception e) {
//            // Handle any exceptions that occur during the save process
//            System.out.println("There has been an error, the game failed to save");
//            System.out.println(e.getClass() + ": " + e.getMessage());
//        }
//    }
    
    public static void saveGame() {
        // Try to establish a connection to the database
        try (Connection conn = connect()) {
            conn.setAutoCommit(false);
            
            // Create the necessary tables if they do not exist
            try (Statement stmt = conn.createStatement()) {
                String createGameTable = "CREATE TABLE GameState (id INT PRIMARY KEY, game BLOB)";
                String createInventoryTable = "CREATE TABLE PlayerInventory (id INT PRIMARY KEY, inventory BLOB)";
                stmt.executeUpdate(createGameTable);  // Attempt to create GameState table
                stmt.executeUpdate(createInventoryTable);  // Attempt to create PlayerInventory table
            } catch (SQLException e) {
            // If tables already exist, ignore the error with SQLState "X0Y32"
            if (!"X0Y32".equals(e.getSQLState())) {
                throw e;  // Re-throw other SQL errors
            }
        }
            
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(game);  // Convert game object to byte array
        }    
            
        } catch (SQLException | IOException e) {
            // Handle any exceptions that occur during the save process
            System.out.println("There has been an error, the game failed to save");
            System.out.println(e.getClass() + ": " + e.getMessage());
        }
    }

    // Loads the game state from a file.
    private static void loadGame() {
        try {
            // Delete the player inventory save file if it exists
            File playerInventorySave = new File("PlayerInventory.sav");
            if (playerInventorySave.exists()) {
                playerInventorySave.delete();
            }

            // Rename PlayerInventorySaved.sav to PlayerInventory.sav if it exists
            File playerInventorySaved = new File("PlayerInventorySaved.sav");
            if (playerInventorySaved.exists()) {
                Files.move(playerInventorySaved.toPath(), playerInventorySave.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }

            // Create a new file input stream to read the game object
            FileInputStream fileInputStream = new FileInputStream("Adv.sav");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            // Read the game object from the file
            game = (TextAdventure) objectInputStream.readObject();
            objectInputStream.close(); // Close the input stream

            System.out.println("\n---Game loaded successfully---");
        } catch (Exception e) {
            // Handle any exceptions that occur during the load process
            System.out.println("There has been an error in loading the game");
            System.out.println(e.getClass() + ": " + e.getMessage());
        }
    }

    /**
     * The main method is the entry point of the application.
     * It creates a new TextAdventure object, sets up the input reader,
     * and enters a loop to handle user commands until the user
     * enters "quit".
     * @param args the command line arguments (not used)
     * @throws IOException if there is an error reading user input
     */
    public static void main(String[] args) throws IOException {
        // Test database connection
        try (Connection conn = connect()) {
            System.out.println("Database connection established successfully!");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database: " + e.getMessage());
        }
        // creates a new TextAdventure Object
        game = new TextAdventure();
        // will be used to reader user input.
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

        String userInput = "";
        String gameOutput = "";

        // Prints the game introduction
        game.printIntroduction();

        // Check if Adv.sav exists
        File advSave = new File("Adv.sav");
        File playerInventorySave = new File("PlayerInventory.sav");
        File playerInventorySaved = new File("PlayerInventorySaved.sav");

        // If Adv.sav does not exist and PlayerInventory.sav exists, delete PlayerInventory.sav
        if (!advSave.exists() && playerInventorySave.exists()) {
            playerInventorySave.delete();
        }

        // If PlayerInventorySaved.sav exists, delete PlayerInventory.sav
        if (playerInventorySaved.exists()) {
            playerInventorySave.delete();
        }

        // If Adv.sav and PlayerInventory.sav exist, rename PlayerInventory.sav to PlayerInventorySaved.sav
        if (advSave.exists() && playerInventorySave.exists()) {
            playerInventorySave.renameTo(playerInventorySaved);
        }

        // Enters the main game loop
        while (true) {
            System.out.print("Enter your command: ");
            userInput = inputReader.readLine();

            if (userInput.equals("save game")) {
                // Save the current game state
                saveGame();
            } else if (userInput.equals("load game")) {
                // Load a saved game state
                loadGame();
            } else if (userInput.equals("quit")) {
                break;
            } else {
                // Runs the users command and prints the output.
                gameOutput = game.runCommand(userInput);
                System.out.println(gameOutput);
            }
        }
    }
}