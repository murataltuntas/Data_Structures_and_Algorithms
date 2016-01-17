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
public class PlayerTest {
    
    public PlayerTest() {
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
     * Test of toString method, of class Player.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Player instance = new Player("Forvet", "Galatasaray", "Burak", "Yilmaz", 12345, 85123.124, 1985);
        String expResult = ("Burak" + " " + "Yilmaz" + "\n"
                      + "ID: " + 12345 + "\n"
                      + "Team: " + "Galatasaray" + "\n"
                      + "Locality: " + "Forvet" + "\n"
                      + "Salary: " + 85123.124 + " $" + "\n"
                      + "Year Of Birth: " + 1985 + "\n");
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLocality method, of class Player.
     */
    @Test
    public void testGetLocality() {
        System.out.println("getLocality");
        Player instance = new Player("Forvet", null, null, null, 0, 0.0, 0);
        String expResult = "Forvet";
        String result = instance.getLocality();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLocality method, of class Player.
     */
    @Test
    public void testSetLocality() {
        System.out.println("setLocality");
        String locality = "Defans";
        Player instance = new Player("Forvet", null, null, null, 0, 0.0, 0);
        instance.setLocality(locality);
        assertEquals(locality, instance.getLocality());
    }

    /**
     * Test of getTeamName method, of class Player.
     */
    @Test
    public void testGetTeamName() {
        System.out.println("getTeamName");
        Player instance = new Player(null, "Galatasaray", null, null, 0, 0, 0);
        String expResult = "Galatasaray";
        String result = instance.getTeamName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTeamName method, of class Player.
     */
    @Test
    public void testSetTeamName() {
        System.out.println("setTeamName");
        String teamName = "Fenerbahce";
        Player instance = new Player(null, "Galatasaray", null, null, 0, 0, 0);
        instance.setTeamName(teamName);
        assertEquals(teamName, instance.getTeamName());
    }
    
}
