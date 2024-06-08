/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DungeonRPG;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rayesa
 */
public class PlayerManagerTest {
    
    public PlayerManagerTest() {
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
     * Test of savePlayerInventory method, of class PlayerManager.
     */
    @Test
    public void testSavePlayerInventory() {
        System.out.println("savePlayerInventory");
        PlayerManager instance = null;
        instance.savePlayerInventory();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadInventory method, of class PlayerManager.
     */
    @Test
    public void testLoadInventory() {
        System.out.println("loadInventory");
        PlayerManager instance = null;
        instance.loadInventory();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of grabLoot method, of class PlayerManager.
     */
    @Test
    public void testGrabLoot() {
        System.out.println("grabLoot");
        String item = "";
        PlayerManager instance = null;
        String expResult = "";
        String result = instance.grabLoot(item);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dropLoot method, of class PlayerManager.
     */
    @Test
    public void testDropLoot() {
        System.out.println("dropLoot");
        String item = "";
        PlayerManager instance = null;
        String expResult = "";
        String result = instance.dropLoot(item);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPlayerInventory method, of class PlayerManager.
     */
    @Test
    public void testCheckPlayerInventory() {
        System.out.println("checkPlayerInventory");
        PlayerManager instance = null;
        String expResult = "";
        String result = instance.checkPlayerInventory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of observePlayerLocation method, of class PlayerManager.
     */
    @Test
    public void testObservePlayerLocation() {
        System.out.println("observePlayerLocation");
        PlayerManager instance = null;
        String expResult = "";
        String result = instance.observePlayerLocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
