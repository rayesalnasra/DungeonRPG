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
 * The Loot class represents a type of item that has a rarity associated with it.
 * It extends the Object class, which provides the basic properties of an object.
*/
public class Loot extends Object implements java.io.Serializable{
    private String rarity;
    
    /**
     * Constructs a new Loot object.
     * It takes the name, description, and rarity of the loot item.
     * @param lootName the name of the loot item
     * @param lootDescription the description of the loot item
     * @param lootRarity the rarity of the loot item
    */
    public Loot(String lootName, String lootDescription, String lootRarity) {
        super(lootName, lootDescription);
        this.rarity = lootRarity;
    }
    
    /**
     * Returns the rarity of the loot.
     * @return the rarity of the loot
    */
    public String getRarity() {
        return this.rarity;
    }
}
