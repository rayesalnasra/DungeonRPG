package DungeonRPG;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test class for the AreaManager class.
 */
public class AreaManagerTest {
    
    public AreaManagerTest() {
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
     * Test of constructArea method, of class AreaManager.
     */
    @Test
    public void testConstructArea() {
        System.out.println("constructArea");
        AreaManager instance = new AreaManager();
        instance.constructArea();
        
        // Verify that the map is not empty after construction
        ArrayList<Area> map = instance.getMap();
        assertNotNull(map);
        assertFalse(map.isEmpty());
        
       
    }

    /**
     * Test of getMap method, of class AreaManager.
     */
    @Test
    public void testGetMap() {
        System.out.println("getMap");
        AreaManager instance = new AreaManager();
        ArrayList<Area> expResult = new ArrayList<>();
        ArrayList<Area> result = instance.getMap();
        assertEquals(expResult, result);
        
    }
}
