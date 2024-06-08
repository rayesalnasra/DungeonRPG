package DungeonRPG;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 *
 * @author rayesa
 */
public class ItemListTest {
    
    private ItemList itemList;
    
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
        itemList = new ItemList();
        itemList.addItemToList(new Loot("carrot", "A crunchy orange carrot", "common"));
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
        String expectedOutput = "carrot: A crunchy orange carrot\n";
        String result = itemList.describeItemsInList();
        assertEquals(expectedOutput, result);
    }

    /**
     * Test of getItemByName method, of class ItemList.
     */
    @Test
    public void testGetItemByName() {
        System.out.println("getItemByName");
        String itemName = "carrot";
        Object expResult = itemList.getItemList().get(0);
        Object result = itemList.getItemByName(itemName);
        assertEquals(expResult, result);
    }

    /**
     * Test of addItemToList method, of class ItemList.
     */
    @Test
    public void testAddItemToList() {
        System.out.println("addItemToList");
        int initialSize = itemList.getItemList().size();
        itemList.addItemToList(new Loot("apple", "A juicy red apple", "common"));
        int newSize = itemList.getItemList().size();
        assertEquals(initialSize + 1, newSize);
    }

    /**
     * Test of getItemList method, of class ItemList.
     */
    @Test
    public void testGetItemList() {
        System.out.println("getItemList");
        ArrayList<Object> expResult = itemList.getItemList();
        ArrayList<Object> result = itemList.getItemList();
        assertEquals(expResult, result);
    }
}
