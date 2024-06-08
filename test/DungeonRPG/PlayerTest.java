package DungeonRPG;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {
    
    public PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setPlayerLocation method, of class Player.
     */
    @Test
    public void testSetPlayerLocation() {
        System.out.println("setPlayerLocation");
        // Create an instance of Player
        Player instance = new Player("TestPlayer", "TestDescription", null, new ItemList());
        // Create an instance of Area representing the player's location
        Area playerLocation = new Area("AreaName", "AreaDescription", 0, 0, 0, 0, new ItemList());
        instance.setPlayerLocation(playerLocation);
        // Assert that the player's location has been set correctly
        assertEquals(playerLocation, instance.getPlayerLocation());
    }

    /**
     * Test of getPlayerLocation method, of class Player.
     */
    @Test
    public void testGetPlayerLocation() {
        System.out.println("getPlayerLocation");
        // Create an instance of Player
        Player instance = new Player("TestPlayer", "TestDescription", null, new ItemList());
        // Create an instance of Area representing the player's location
        Area expectedLocation = new Area("AreaName", "AreaDescription", 0, 0, 0, 0, new ItemList());
        // Set the player's location
        instance.setPlayerLocation(expectedLocation);
        // Assert that the player's location matches the expected location
        assertEquals(expectedLocation, instance.getPlayerLocation());
    }
}
