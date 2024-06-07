package DungeonRPG;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rayesa
 */

/**
 * The Object class represents a basic game object with a name and description.
 * It serves as the base class for other more specialized object types in the game.
*/

public class Object implements java.io.Serializable {
    private String objectName;
    private String objectDescription;
    
    /**
     * Constructs a new Object with the specified name and description.
     * @param objectName the name of the object
     * @param objectDescription the description of the object
    */
    public Object(String objectName, String objectDescription) {
        this.objectName = objectName;
        this.objectDescription = objectDescription;
    }
    
    /**
     * Returns the name of the object.
     * @return the name of the object
    */
    public String getObjectName() {
        return this.objectName;
    }
    
    /**
     * Sets the name of the object.
     * @param objectName the new name of the object
    */
    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }
    
    /**
     * Returns the description of the object.
     * @return the description of the object
    */
    public String getDescription() {
        return this.objectDescription;
    }
    
    /**
     * Sets the description of the object.
     * @param objectDescription the new description of the object
    */
    public void setDescription(String objectDescription) {
        this.objectDescription = objectDescription;
    }
}
