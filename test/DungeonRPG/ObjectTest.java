package DungeonRPG;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ObjectTest {
    
    public ObjectTest() {
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
     * Test of getObjectName method, of class Object.
     */
    @Test
    public void testGetObjectName() {
        System.out.println("getObjectName");
        String objectName = "TestObject";
        String objectDescription = "TestDescription";
        Object instance = new Object(objectName, objectDescription);
        String expResult = "TestObject";
        String result = instance.getObjectName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setObjectName method, of class Object.
     */
    @Test
    public void testSetObjectName() {
        System.out.println("setObjectName");
        String objectName = "TestObject";
        String objectDescription = "TestDescription";
        Object instance = new Object(objectName, objectDescription);
        String newObjectName = "NewTestObject";
        instance.setObjectName(newObjectName);
        assertEquals(newObjectName, instance.getObjectName());
    }

    /**
     * Test of getDescription method, of class Object.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        String objectName = "TestObject";
        String objectDescription = "TestDescription";
        Object instance = new Object(objectName, objectDescription);
        String expResult = "TestDescription";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class Object.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String objectName = "TestObject";
        String objectDescription = "TestDescription";
        Object instance = new Object(objectName, objectDescription);
        String newDescription = "NewTestDescription";
        instance.setDescription(newDescription);
        assertEquals(newDescription, instance.getDescription());
    }
}
