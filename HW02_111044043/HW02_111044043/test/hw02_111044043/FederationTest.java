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
public class FederationTest {
    
    President prsdnt = new President("Federation", "Unal", "Aysal", 201505, 421.612, 1965);
    VicePresident vice = new VicePresident("Federation", "Hakan", "Baysal", 201575, 421.612, 1965);
    TechnicalManager tcM = new TechnicalManager("Galatasaray", "Hamza", "HAMZAOGLU", 201885, 463.214, 1988);
    Player plyr = new Player("Forvet", "Galatasaray", "Murat", "ALTUNTAS", 111044, 562.12, 1992);
    ArrayList<Integer> scores = new ArrayList<>();
    ArrayList<String> matchScheduleAYear = new ArrayList<>();
    ArrayList<Player> plyrs = new ArrayList<Player>();
    Team team = new Team("Galatasaray", tcM, "Sari-Kirmizi", prsdnt, plyrs, vice, scores, matchScheduleAYear);
    ArrayList<Team> teams = new ArrayList<>();
    
    public FederationTest() {
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
     * Test of toString method, of class Federation.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Federation instance = new Federation(prsdnt, vice, teams);
        String expResult = ( prsdnt.toString()
                        + vice.toString());
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of addTeam method, of class Federation.
     */
    @Test
    public void testAddTeam() {
        System.out.println("addTeam");
        Team team = new Team("Trabzon", tcM, "Bordo-Mavi", prsdnt, plyrs, vice, scores, matchScheduleAYear);
        Federation instance = new Federation(prsdnt, vice, teams);
        instance.addTeam(team);
        assertEquals(instance.getTeams().get(0), team);
    }

    /**
     * Test of deleteTeam method, of class Federation.
     */
    @Test
    public void testDeleteTeam() {
        System.out.println("deleteTeam");
        Team team = new Team("Trabzon", tcM, "Bordo-Mavi", prsdnt, plyrs, vice, scores, matchScheduleAYear);
        Federation instance = new Federation(prsdnt, vice, teams);
        instance.addTeam(team);
        instance.addTeam(team);
        instance.deleteTeam(team);
        assertEquals(instance.getTeams().get(instance.getTeams().size()-1), team);
    }

    /**
     * Test of changePresident method, of class Federation.
     */
    @Test
    public void testChangePresident() {
        System.out.println("changePresident");
        President prsd = new President("Federation", "Vural", "Aysal", 201505, 421.612, 1965);
        Federation instance = new Federation(prsdnt, vice, teams);
        instance.changePresident(prsd);
        assertEquals(instance.getPresident().toString(), prsd.toString());
    }

    /**
     * Test of changeVicePresident method, of class Federation.
     */
    @Test
    public void testChangeVicePresident() {
        System.out.println("changeVicePresident");
        VicePresident vcPrsdnt = new VicePresident("Federation", "Hasan", "Yardimci", 201575, 421.612, 1965);
        Federation instance = new Federation(prsdnt, vice, teams);
        instance.changeVicePresident(vcPrsdnt);
        assertEquals(instance.getVicePresident().toString(), vcPrsdnt.toString());
    }

    /**
     * Test of matchSchedule method, of class Federation.
     */
    @Test
    public void testMatchSchedule() {
        System.out.println("matchSchedule");
        String teamName = "Trabzonspor";
        Federation instance = new Federation(prsdnt, vice, teams);
        ArrayList<String> expResult = new ArrayList<>();
        ArrayList<String> result = instance.matchSchedule(teamName);
        assertEquals(expResult, result);
    }

    /**
     * Test of scoresWeekly method, of class Federation.
     */
    @Test
    public void testScoresWeekly() {
        System.out.println("scoresWeekly");
        int week = 0;
        Federation instance = new Federation(prsdnt, vice, teams);
        ArrayList<String> expResult = new ArrayList<String>();
        ArrayList<String> result = instance.scoresWeekly(week);
        assertEquals(expResult, result);
    }

    /**
     * Test of standingTableWeekly method, of class Federation.
     */
    @Test
    public void testStandingTableWeekly() {
        System.out.println("standingTableWeekly");
        int week = 1;
        Federation instance = new Federation(prsdnt, vice, teams);
        ArrayList<String> expResult = new ArrayList<String>();
        ArrayList<String> result = instance.standingTableWeekly(week);
        assertEquals(expResult, result);
    }

    /**
     * Test of searchTeam method, of class Federation.
     */
    @Test
    public void testSearchTeam() {
        System.out.println("searchTeam");
        String teamName = "";
        Federation instance = new Federation(prsdnt, vice, teams);
        Team expResult = null;
        Team result = instance.searchTeam(teamName);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPresident method, of class Federation.
     */
    @Test
    public void testGetPresident() {
        System.out.println("getPresident");
        Federation instance = new Federation(prsdnt, vice, teams);
        President expResult = prsdnt;
        President result = instance.getPresident();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPresident method, of class Federation.
     */
    @Test
    public void testSetPresident() {
        System.out.println("setPresident");
        President president = null;
        Federation instance = new Federation(prsdnt, vice, teams);
        instance.setPresident(president);
        assertEquals(instance.getPresident(), president);
    }

    /**
     * Test of getVicePresident method, of class Federation.
     */
    @Test
    public void testGetVicePresident() {
        System.out.println("getVicePresident");
        Federation instance = new Federation(prsdnt, vice, teams);
        VicePresident expResult = vice;
        VicePresident result = instance.getVicePresident();
        assertEquals(expResult, result);
    }

    /**
     * Test of setVicePresident method, of class Federation.
     */
    @Test
    public void testSetVicePresident() {
        System.out.println("setVicePresident");
        VicePresident vicePresident = null;
        Federation instance = new Federation(prsdnt, vice, teams);
        instance.setVicePresident(vicePresident);
    }

    /**
     * Test of getTeams method, of class Federation.
     */
    @Test
    public void testGetTeams() {
        System.out.println("getTeams");
        Federation instance = new Federation(prsdnt, vice, teams);
        ArrayList<Team> expResult = new ArrayList<Team>();
        ArrayList<Team> result = instance.getTeams();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTeams method, of class Federation.
     */
    @Test
    public void testSetTeams() {
        System.out.println("setTeams");
        ArrayList<Team> tms = null;
        Federation instance = new Federation(prsdnt, vice, teams);
        instance.setTeams(tms);
    }
    
}
