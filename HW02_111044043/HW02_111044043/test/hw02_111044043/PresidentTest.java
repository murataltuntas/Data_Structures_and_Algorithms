package hw02_111044043;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Murat
 */
public class PresidentTest {
    
    public PresidentTest() {
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
     * Test of getPlaceOfTheMission method, of class President.
     */
    @Test
    public void testGetPlaceOfTheMission() {
        System.out.println("getPlaceOfTheMission");
        President instance = new President("Federation", "Unal", "Aysal", 201505, 421.612, 1965);
        String expResult = "Federation";
        String result = instance.getPlaceOfTheMission();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPlaceOfTheMission method, of class President.
     */
    @Test
    public void testSetPlaceOfTheMission() {
        System.out.println("setPlaceOfTheMission");
        String placeOfTheMission = "Federation";
        President instance = new President("Federation", "Unal", "Aysal", 201505, 421.612, 1965);
        instance.setPlaceOfTheMission(placeOfTheMission);
        assertEquals(instance.getPlaceOfTheMission(), placeOfTheMission);
    }

    /**
     * Test of toString method, of class President.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        President instance = new President("Federation", "Unal", "Aysal", 201505, 421.612, 1965);
        String expResult = ("Unal" + " " + "Aysal" + "\n"
                      + "ID: " + 201505 + "\n"
                      + "Salary: " + 421.612 + " $" + "\n"
                      + "Year Of Birth: " + 1965 + "\n"
                      + "Place of The Mission: " + "Federation" + "\n\n");
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
