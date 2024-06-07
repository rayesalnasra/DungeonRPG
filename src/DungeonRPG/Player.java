package DungeonRPG;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author billalg
 */
public class Player extends ItemInventory {
    private Area playerLocation;

    /**
     * Constructs a new Player object.
     * It initializes the player's name, description, current location,
     * and the player's item inventory.
     * @param playerName the name of the player
     * @param playerDescription the description of the player
     * @param playerLocation the player's current location
     * @param itemList the player's item inventory
     */
    public Player(String playerName, String playerDescription,
                  Area playerLocation, ItemList itemList) {
        super(playerName, playerDescription, itemList);
        this.playerLocation = playerLocation;
    }

    /**
     * Sets the player's current location.
     * @param playerLocation the new location for the player
     */
    public void setPlayerLocation(Area playerLocation) {
        this.playerLocation = playerLocation;
    }

    /**
     * Returns the player's current location.
     * @return the player's current location
     */
    public Area getPlayerLocation() {
        return playerLocation;
    }
}