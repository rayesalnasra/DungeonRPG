package DungeonRPG;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
    
    // Saves the player's inventory to a file
    private void savePlayerInventory() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("PlayerInventory.sav"))) {
            oos.writeObject(playerInventory);
        } catch (IOException e) {
            System.out.println("Error saving player inventory: " + e.getMessage());
        }
    }

    // Loads the player's inventory from a file
    private ItemList loadPlayerInventory() {
        File file = new File("PlayerInventory.sav");
        if (!file.exists()) {
            return new ItemList(); // Return an empty inventory if file doesn't exist
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (ItemList) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading player inventory: " + e.getMessage());
            return null;
        }
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
            message = "There is no loot here.";
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
    public void checkPlayerInventory() {
        System.out.println("Your inventory:");
        System.out.println(playerInventory.describeItemsInList());
    }

    // Displays a description of the player's current location
    public void observePlayerLocation() {
        System.out.println(game.getPlayer().getPlayerLocation().describeArea());
    }
}
