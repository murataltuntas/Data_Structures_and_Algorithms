/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class VicePresidentTest {
    
    public VicePresidentTest() {
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
     * Test of getPlaceOfTheMission method, of class VicePresident.
     */
    @Test
    public void testGetPlaceOfTheMission() {
        System.out.println("getPlaceOfTheMission");
        VicePresident instance = new VicePresident("Federation", "Unal", "Aysal", 201505, 421.612, 1965);
        String expResult = "Federation";
        String result = instance.getPlaceOfTheMission();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPlaceOfTheMission method, of class VicePresident.
     */
    @Test
    public void testSetPlaceOfTheMission() {
        System.out.println("setPlaceOfTheMission");
        String placeOfTheMission = "Federation";
        VicePresident instance = new VicePresident("Federation", "Unal", "Aysal", 201505, 421.612, 1965);
        instance.setPlaceOfTheMission(placeOfTheMission);
        assertEquals(instance.getPlaceOfTheMission(), placeOfTheMission);
    }

    /**
     * Test of toString method, of class VicePresident.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        VicePresident instance = new VicePresident("Federation", "Hakan", "Uyanik", 201505, 421.612, 1965);
        String expResult = ("Hakan" + " " + "Uyanik" + "\n"
                      + "ID: " + 201505 + "\n"
                      + "Salary: " + 421.612 + " $" + "\n"
                      + "Year Of Birth: " + 1965 + "\n"
                      + "Place of The Mission: " + "Federation" + "\n\n");
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
