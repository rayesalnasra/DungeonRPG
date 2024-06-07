package DungeonRPG;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author billalg
 */

/**
 * The ItemInventory class represents an object that has an inventory of items.
 * It extends the Object class, which provides the basic properties of an object.
*/
public class ItemInventory extends Object implements java.io.Serializable{
    private ItemList itemInventory = new ItemList();
    
        
    /**
     * Constructs a new ItemInventory object.
     * It takes the name, description, and an item list for the inventory.
     * @param itemName the name of the item inventory
     * @param itemDescription the description of the item inventory
     * @param itemList the list of items in the inventory
    */
    public ItemInventory(String itemName, String itemDescription, ItemList itemList) {
        super(itemName, itemDescription);
        itemInventory = itemList;
    }
    
    /**
     * Returns the item inventory.
     * @return the item inventory
    */
    public ItemList getItemInventory() {
        return this.itemInventory;
    }
    
    /**
     * Sets the item inventory.
     * @param itemList the new item inventory
    */
    public void setItemInventory(ItemList itemList) {
        this.itemInventory = itemList;
    }
}
