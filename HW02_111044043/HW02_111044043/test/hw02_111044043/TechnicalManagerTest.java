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
public class TechnicalManagerTest {
    
    public TechnicalManagerTest() {
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
     * Test of getTeamName method, of class TechnicalManager.
     */
    @Test
    public void testGetTeamName() {
        System.out.println("getTeamName");
        TechnicalManager instance = new TechnicalManager("Galatasaray", "Hamza", "HAMZAOGLU", 201885, 463.214, 1988);
        String expResult = "Galatasaray";
        String result = instance.getTeamName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTeamName method, of class TechnicalManager.
     */
    @Test
    public void testSetTeamName() {
        System.out.println("setTeamName");
        String teamName = "Galatasaray";
        TechnicalManager instance = new TechnicalManager("Galatasaray", "Hamza", "HAMZAOGLU", 201885, 463.214, 1988);
        instance.setTeamName(teamName);
        assertEquals(instance.getTeamName(), teamName);
    }

    /**
     * Test of toString method, of class TechnicalManager.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        TechnicalManager instance = new TechnicalManager("Galatasaray", "Hamza", "HAMZAOGLU", 201885, 463.214, 1988);
        String expResult = ("Hamza" + " " + "HAMZAOGLU" + "\n"
                      + "ID: " + 201885 + "\n"
                      + "Salary: " + 463.214 + " $" + "\n"
                      + "Year Of Birth: " + 1988 + "\n"
                      + "Team: " + "Galatasaray"+ "\n\n");
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
