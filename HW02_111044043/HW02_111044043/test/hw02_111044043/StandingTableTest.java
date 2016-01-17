/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hw02_111044043;

import java.util.ArrayList;
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
public class StandingTableTest {
    
    President prsdnt = new President("Federation", "Unal", "Aysal", 201505, 421.612, 1965);
    VicePresident vice = new VicePresident("Federation", "Hakan", "Baysal", 201575, 421.612, 1965);
    TechnicalManager tcM = new TechnicalManager("Galatasaray", "Hamza", "HAMZAOGLU", 201885, 463.214, 1988);
    ArrayList<Integer> scores = new ArrayList<>();
    ArrayList<String> matchScheduleAYear = new ArrayList<>();
    ArrayList<Player> plyrs = new ArrayList<Player>();    
    Team team = new Team("Galatasaray", tcM, "Sari-Kirmizi", prsdnt, plyrs, vice, scores, matchScheduleAYear);
    ArrayList<Team> teams = new ArrayList<>();
    
    public StandingTableTest() {
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
     * Test of fixture method, of class StandingTable.
     */
    @Test
    public void testFixture() {
        System.out.println("fixture");
        Federation fed = new Federation(prsdnt, vice, teams);
        int week = 0;
        StandingTable instance = new StandingTable(fed);
        instance.fixture(week);
    }
    
}
