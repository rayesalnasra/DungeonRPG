package DungeonRPG;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test class for the Loot class.
 */
public class LootTest {

    public LootTest() {
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
     * Test of getRarity method, of class Loot.
     */
    @Test
    public void testGetRarity() {
        // Create a new Loot object with rarity "Common"
        Loot instance = new Loot("Sword", "A powerful weapon", "Common");
        
        // Define the expected result
        String expResult = "Common";
        
        // Call the getRarity method and store the result
        String result = instance.getRarity();
        
        // Assert that the actual result matches the expected result
        assertEquals(expResult, result);
    }
}
