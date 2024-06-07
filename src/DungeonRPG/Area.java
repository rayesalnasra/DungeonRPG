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
 * The Area class represents a location in the game world.
 * Each area has a name, description, and a set of exits that
 * connect it to other areas.
*/
public class Area extends ItemInventory implements java.io.Serializable{
    private String areaName;
    private String areaDescription;
    private int northExit;
    private int southExit;
    private int westExit;
    private int eastExit;
    private ArrayList<Object> itemList;
    
    
    /**
     * Constructs a new Area object.
     * It takes the area name, description, and the exits to
     * other areas, as well as the items present in the area.
     * @param areaName the name of the area
     * @param areaDescription the description of the area
     * @param northExit the index of the area to the north
     * @param southExit the index of the area to the south
     * @param westExit the index of the area to the west
     * @param eastExit the index of the area to the east
     * @param itemList the list of items present in the area
    */
    public Area (String areaName, String areaDescription,
            int northExit, int southExit, int westExit, int eastExit, ItemList itemList) {
        
        super(areaName, areaDescription, itemList);
        this.areaName = areaName;
        this.areaDescription = areaDescription;
        this.northExit = northExit;
        this.southExit = southExit;
        this.westExit = westExit;
        this.eastExit = eastExit;
    }
    
    /*
     * Describes the area, including its name, description, and the
     * items present in the area.
     * @return a string describing the area
    */
    public String describeArea() {
        String message = "You are in the " +this.areaName + ": " + this.areaDescription + ".\n";
        message += "You find items laying on the floor: \n";
        message += getItemInventory().describeItemsInList();
        return message;
    }
    
    /**
     * Returns the index of the area to the north.
     * @return the index of the area to the north
     */
    public int getNorthExit() {
        return northExit;
    }

    /**
     * Sets the index of the area to the north.
     * @param northExit the new index of the area to the north
    */
    public void setNorthExit(int northExit) {
        this.northExit = northExit;
    }

    /**
     * Returns the index of the area to the south.
     * @return the index of the area to the south
    */
    public int getSouthExit() {
        return southExit;
    }

    /**
     * Sets the index of the area to the south.
     * @param southExit the new index of the area to the south
    */
    public void setSouthExit(int southExit) {
        this.southExit = southExit;
    }
    
    /**
     * Returns the index of the area to the west.
     * @return the index of the area to the west
    */
    public int getWestExit() {
        return westExit;
    }

    /**
     * Sets the index of the area to the west.
     * @param westExit the new index of the area to the west
    */
    public void setWestExit(int westExit) {
        this.westExit = westExit;
    }

    /**
     * Returns the index of the area to the east.
     * @return the index of the area to the east
    */
    public int getEastExit() {
        return eastExit;
    }

    /**
     * Sets the index of the area to the east.
     * @param eastExit the new index of the area to the east
    */
    public void setEastExit(int eastExit) {
        this.eastExit = eastExit;
    }
}
