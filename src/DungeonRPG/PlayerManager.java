package DungeonRPG;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rayesa
 */

public class PlayerManager implements Serializable {
    private TextAdventure game;
    private ItemList playerInventory; // Store player's inventory in the class

    public PlayerManager(TextAdventure game) {
        this.game = game;
        this.playerInventory = loadPlayerInventory(); // Load player's inventory upon initialization
    }

    private static Connection connect() throws SQLException {
        String url = "jdbc:derby:DungeonRPGDatabase;create=true"; // Adjust the URL as needed
        return DriverManager.getConnection(url);
    }


    public void savePlayerInventory() {
        try (Connection conn = connect()) {
            conn.setAutoCommit(false); // Start transaction
            // Ensure the PlayerInventory table exists
            try (Statement stmt = conn.createStatement()) {
                // SQL statement to create the PlayerInventory table if it doesn't exist
                String createInventoryTable = "CREATE TABLE PlayerInventory (id INT PRIMARY KEY, inventory BLOB)";
                stmt.executeUpdate(createInventoryTable); // Execute the SQL statement
            } catch (SQLException e) {
                // If the table already exists, ignore the error with SQLState "X0Y32"
                if (!e.getSQLState().equals("X0Y32")) {
                    throw e; // Re-throw other SQL errors
                }
            }
            
            // Serialize the player inventory
            ByteArrayOutputStream baos = new ByteArrayOutputStream(); // Create a ByteArrayOutputStream
            try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
                oos.writeObject(playerInventory); // Serialize the player inventory object
            }
            
            // Update the player inventory in the database
            String updateInventory = "UPDATE PlayerInventory SET inventory = ? WHERE id = 1";
            try (PreparedStatement pstmt = conn.prepareStatement(updateInventory)) {
                pstmt.setBytes(1, baos.toByteArray()); // Set the serialized inventory as a byte array
                int rowsAffected = pstmt.executeUpdate(); // Execute the update
            
                // If no rows were updated, insert the inventory as a new row
                if (rowsAffected == 0) {
                    String insertInventory = "INSERT INTO PlayerInventory (id, inventory) VALUES (1, ?)";
                    try (PreparedStatement pstmtInsert = conn.prepareStatement(insertInventory)) {
                        pstmtInsert.setBytes(1, baos.toByteArray()); // Set the byte array in the insert statement
                        pstmtInsert.executeUpdate(); // Execute the insert
                    }
                }
            }
            
            conn.commit(); // Commit the transaction to save changes
            System.out.println("Player inventory saved successfully!"); // Inform the user of success
            
        } catch (SQLException | IOException e) {
            // Handle any exceptions that occur during the save process
            System.out.println("Error saving player inventory: " + e.getMessage());
        }
    }
    
    
    private ItemList loadPlayerInventory() {
       try (Connection conn = connect()) {
        // Retrieve the player inventory from the database
            String selectInventory = "SELECT inventory FROM PlayerInventory WHERE id = 1";
            
            // Prepare and execute the SQL query
            try (PreparedStatement pstmt = conn.prepareStatement(selectInventory);
             ResultSet rs = pstmt.executeQuery()) {
            // Check if a record for player inventory exists
                if (rs.next()) {
                    // If a record is found, retrieve the inventory data
                    byte[] inventoryData = rs.getBytes("inventory");
                
                // Deserialize the inventory data
                try (ByteArrayInputStream bais = new ByteArrayInputStream(inventoryData);
                     ObjectInputStream ois = new ObjectInputStream(bais)) {
                    return (ItemList) ois.readObject(); // Return the deserialized ItemList
                }
            } else {
                // If no record is found, inform the user and return an empty inventory
                System.out.println("No player inventory found in the database.");
                return new ItemList(); // Return an empty ItemList
            }
         }  
       } catch (SQLException | IOException | ClassNotFoundException e) {
            // Handle any exceptions that occur during the load process
            System.out.println("Error loading player inventory: " + e.getMessage());
            return null; // Return null to indicate failure
        }  
    }
    
    public void loadInventory() {
        this.playerInventory = loadPlayerInventory();
    }
    
    public void resetInventory() {
        this.playerInventory = new ItemList();
        savePlayerInventory(); // Save the empty inventory to the database
    }

    // Moves an item from one ItemList to another
    private void moveItemTo(Object item, ItemList sourceList, ItemList destinationList) {
        sourceList.getItemList().remove(item);
        destinationList.getItemList().add(item);
        savePlayerInventory(); // Save inventory after moving item
    }

    // Allows the player to grab an item from the current area
    public String grabLoot(String item) {
        String message = "";

        Object areaHasItem = game.getPlayer().getPlayerLocation().getItemInventory().getItemByName(item);

        if (areaHasItem == null) {
            message = "This item is not here";
        } else {
            moveItemTo(areaHasItem, game.getPlayer().getPlayerLocation().getItemInventory(), playerInventory);
            message = item + " has been taken.";
        }
        return message;
    }

    // Allows the player to drop an item from their inventory
    public String dropLoot(String item) {
        String message = "";

        Object playerHasItem = playerInventory.getItemByName(item);

        if (playerHasItem == null) {
            message = "You don't have this item.";
        } else {
            moveItemTo(playerHasItem, playerInventory, game.getPlayer().getPlayerLocation().getItemInventory());
            message = item + " has been dropped.";
        }

        return message;
    }

    // Displays the contents of the player's inventory
    public String checkPlayerInventory() {
        String message = "Your inventory:\n" + playerInventory.describeItemsInList();
        return message;
    }

    // Displays a description of the player's current location
    public String observePlayerLocation() {
        return game.getPlayer().getPlayerLocation().describeArea();
    }
}
