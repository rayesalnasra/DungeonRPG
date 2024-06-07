package DungeonRPG;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author billalg
 */

/**
 * The AreaManager class is responsible for constructing and managing the game map.
 * It creates the different areas of the game world and the items within them.
*/
public class AreaManager implements java.io.Serializable {
    private ArrayList<Area> map;
    
    /**
     * Constructs a new AreaManager object.
     * It initializes an empty ArrayList to store the game areas.
    */
    public AreaManager() {
        this.map = new ArrayList<>();
    }
    
    
    /**
     * Constructs the game map by creating a set of areas and items.
     * It creates the item lists for each area, and then adds the areas to the map.
     */
    public void constructArea() {
        // Create item lists for each area
        // Troll's Lair Items
        ItemList trollRoomList = new ItemList();
        trollRoomList.addItemToList(new Loot("carrot", "A crunchy orange carrot", "common"));

        // Enchanted Forest Items
        ItemList forestList = new ItemList();
        forestList.addItemToList(new Loot("sausage", "A juicy sausage", "common"));

        // Dark Cave Items
        ItemList caveList = new ItemList();
        caveList.addItemToList(new Loot("paper", "A scrap of paper with a cryptic message", "uncommon"));
        caveList.addItemToList(new Loot("pencil", "A worn-out pencil", "common"));

        // Castle Dungeon Items
        ItemList dungeonList = new ItemList();
        dungeonList.addItemToList(new Loot("ring", "A powerful enchanted ring", "rare"));
        dungeonList.addItemToList(new Loot("wombat", "A friendly, furry wombat", "common"));

        
        // Create the areas and add them to the map
        map.add(new Area("Troll's Lair", "A dimly lit chamber with the lingering stench of trolls", 
                -1, 2, -1, 1, trollRoomList));
        map.add(new Area("Enchanted Forest", "A dense forest alive with mystical energies", -1, -1, 0, -1,forestList));
        map.add(new Area("Dark Cave", "A foreboding cavern shrouded in darkness", 0, -1, -1, 3,caveList));
        map.add(new Area("Castle Dungeon", "A grim dungeon beneath the ancient castle walls", -1, -1, 2, -1,dungeonList));
    }
    
    /**
     * Returns the game map.
     * @return the game map
    */
    public ArrayList<Area> getMap() {
        return this.map;
    }
}
