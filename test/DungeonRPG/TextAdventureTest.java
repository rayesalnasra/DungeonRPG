package DungeonRPG;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TextAdventureTest {
    
    public TextAdventureTest() {
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
     * Test of getPlayer method, of class TextAdventure.
     */
    @Test
    public void testGetPlayer() {
        System.out.println("getPlayer");
        TextAdventure instance = new TextAdventure();
        Player result = instance.getPlayer();
        assertNotNull(result);
    }

    /**
     * Test of runCommand method, of class TextAdventure.
     */
    @Test
    public void testRunCommand() {
        System.out.println("runCommand");
        TextAdventure instance = new TextAdventure();
        String userInput = "move north";
        String expResult = instance.movePlayerTo("north");
        String result = instance.runCommand(userInput);
        assertEquals(expResult, result);
    }

    /**
     * Test of movePlayerTo method, of class TextAdventure.
     */
    @Test
    public void testMovePlayerTo() {
        System.out.println("movePlayerTo");
        TextAdventure instance = new TextAdventure();
        String direction = "north";
        String expResult = "No Exit";
        String result = instance.movePlayerTo(direction);
        assertEquals(expResult, result);
    }

    /**
     * Test of printIntroduction method, of class TextAdventure.
     */
    @Test
    public void testPrintIntroduction() {
        System.out.println("printIntroduction");
        TextAdventure instance = new TextAdventure();
        String expResult = "As you tumble down a mysterious rabbit hole, you land softly in\n"
                + "an underground cavern permeated with the scent of ancient troll dwellings.\n"
                + "Which direction shall you venture? (Or type 'quit' to abandon your journey)\n"
                + "Enter 'move' followed by the direction you wish to go (north, south, west, east):\n"
                + instance.getPlayer().getPlayerLocation().describeArea();
        String result = instance.printIntroduction();
        assertEquals(expResult, result);
    }
}
