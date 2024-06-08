package DungeonRPG;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test class for PlayerManager.
 */
public class PlayerManagerTest {
    
    private PlayerManager playerManager;
    private TextAdventure textAdventure;
    
    public PlayerManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        // Perform any initialization that needs to be done once for all tests
    }
    
    @AfterClass
    public static void tearDownClass() {
        // Perform any clean-up operations that need to be done once after all tests
    }
    
    @Before
    public void setUp() {
        // Initialize PlayerManager, TextAdventure, and related objects before each test
        textAdventure = new TextAdventure();
        playerManager = new PlayerManager(textAdventure);
    }
    
    @After
    public void tearDown() {
        // Perform any clean-up operations that need to be done after each test
    }

    /**
     * Test of savePlayerInventory method, of class PlayerManager.
     */
    @Test
    public void testSavePlayerInventory() {
        System.out.println("savePlayerInventory");
        try {
            playerManager.savePlayerInventory();
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    /**
     * Test of loadInventory method, of class PlayerManager.
     */
    @Test
    public void testLoadInventory() {
        System.out.println("loadInventory");
        try {
            playerManager.loadInventory();
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    /**
     * Test of grabLoot method, of class PlayerManager.
     */
    @Test
    public void testGrabLoot() {
        System.out.println("grabLoot");
        String item = "carrot";
        String expectedMessage = "carrot has been taken.";
        String result = playerManager.grabLoot(item);
        assertEquals(expectedMessage, result);
    }

    /**
     * Test of dropLoot method, of class PlayerManager.
     */
    @Test
    public void testDropLoot() {
        System.out.println("dropLoot");
        String item = "carrot";
        String expectedMessage = "carrot has been dropped.";
        String result = playerManager.dropLoot(item);
        assertEquals(expectedMessage, result);
    }

    /**
     * Test of checkPlayerInventory method, of class PlayerManager.
     */
    @Test
    public void testCheckPlayerInventory() {
        System.out.println("checkPlayerInventory");
        // Ensure the method does not return null
        assertNotNull(playerManager.checkPlayerInventory());
    }

    /**
     * Test of observePlayerLocation method, of class PlayerManager.
     */
    @Test
    public void testObservePlayerLocation() {
        System.out.println("observePlayerLocation");
        // Ensure the method does not return null
        assertNotNull(playerManager.observePlayerLocation());
    }
}
