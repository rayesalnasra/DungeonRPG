/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DungeonRPG;

import java.util.ArrayList;
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
public class ItemListTest {
    
    public ItemListTest() {
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
     * Test of describeItemsInList method, of class ItemList.
     */
    @Test
    public void testDescribeItemsInList() {
        System.out.println("describeItemsInList");
        ItemList instance = new ItemList();
        String expResult = "";
        String result = instance.describeItemsInList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemByName method, of class ItemList.
     */
    @Test
    public void testGetItemByName() {
        System.out.println("getItemByName");
        String itemName = "";
        ItemList instance = new ItemList();
        Object expResult = null;
        Object result = instance.getItemByName(itemName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addItemToList method, of class ItemList.
     */
    @Test
    public void testAddItemToList() {
        System.out.println("addItemToList");
        Object item = null;
        ItemList instance = new ItemList();
        instance.addItemToList(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemList method, of class ItemList.
     */
    @Test
    public void testGetItemList() {
        System.out.println("getItemList");
        ItemList instance = new ItemList();
        ArrayList<Object> expResult = null;
        ArrayList<Object> result = instance.getItemList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
