package DungeonRPG;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rayesa
 */

/**
 * The ItemList class represents a collection of items.
 * It provides methods to manage the list of items, such as describing the items,
 * finding an item by name, and adding items to the list.
*/
public class ItemList implements java.io.Serializable{
    private ArrayList<Object> itemList;
    
    /**
     * Constructs a new ItemList object.
     * It initializes an empty ArrayList to store the items.
    */
    public ItemList() {
        this.itemList = new ArrayList<>();
    }
    
    /**
     * Describes the items in the item list.
     * If the list is empty, it returns "nothing is in the list".
     * Otherwise, it returns a string describing each item in the list.
     * @return a string describing the items in the list
    */
    public String describeItemsInList() {
        String message = "";
        if (this.itemList.size() == 0) {
            message = "There is no loot in this area";
        } else {
            for (Object item: this.itemList) {
                message += item.getObjectName() + ": "+ item.getDescription() + "\n";
            }
        }
        
        return message;
    }
   
    /**
     * Finds an item in the item list by its name.
     * The name is converted to lowercase and trimmed before searching.
     * @param itemName the name of the item to find
     * @return the item object if found, or null if not found
    */
    public Object getItemByName(String itemName) {
        String itemNameLowerCase = itemName.trim().toLowerCase();
        String itemNameInList = "";
        Object foundItem = null;
        for (Object item: this.itemList) {
            itemNameInList = item.getObjectName().trim().toLowerCase();
            
            if (itemNameInList.equals(itemNameLowerCase)) {
                foundItem = item;
            }
        }
        
        return foundItem;
    }
    
    /**
     * Adds an item to the item list.
     * @param item the item to add
    */
    public void addItemToList(Object item) {
        this.itemList.add(item);
    }
    
    /**
     * Returns the item list.
     * @return the item list
    */
    public ArrayList<Object> getItemList() {
        return this.itemList;
    }
    
}
