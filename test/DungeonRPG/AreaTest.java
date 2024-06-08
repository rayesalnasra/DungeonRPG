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
public class AreaTest {
    
    private Area area;
    private ItemList itemList;
    
    public AreaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        itemList = new ItemList();
        itemList.addItemToList(new Loot("carrot", "A crunchy orange carrot", "common"));
        area = new Area("Troll's Lair", "A dimly lit chamber with the lingering stench of trolls", -1, 2, -1, 1, itemList);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of describeArea method, of class Area.
     */
    @Test
    public void testDescribeArea() {
        System.out.println("describeArea");
        String expectedOutput = "You are in the Troll's Lair: A dimly lit chamber with the lingering stench of trolls.\n" +
                                "You find items laying on the floor: \n" +
                                "carrot: A crunchy orange carrot\n";
        String result = area.describeArea();
        assertEquals(expectedOutput, result);
    }

    /**
     * Test of getNorthExit method, of class Area.
     */
    @Test
    public void testGetNorthExit() {
        System.out.println("getNorthExit");
        int expResult = -1;
        int result = area.getNorthExit();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSouthExit method, of class Area.
     */
    @Test
    public void testGetSouthExit() {
        System.out.println("getSouthExit");
        int expResult = 2;
        int result = area.getSouthExit();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWestExit method, of class Area.
     */
    @Test
    public void testGetWestExit() {
        System.out.println("getWestExit");
        int expResult = -1;
        int result = area.getWestExit();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEastExit method, of class Area.
     */
    @Test
    public void testGetEastExit() {
        System.out.println("getEastExit");
        int expResult = 1;
        int result = area.getEastExit();
        assertEquals(expResult, result);
    }
}