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
public class TeamTest {
    
    President prsdnt = new President("Federation", "Unal", "Aysal", 201505, 421.612, 1965);
    VicePresident vice = new VicePresident("Federation", "Hakan", "Baysal", 201575, 421.612, 1965);
    TechnicalManager tcM = new TechnicalManager("Galatasaray", "Hamza", "HAMZAOGLU", 201885, 463.214, 1988);
    Player plyr = new Player("Forvet", "Galatasaray", "Murat", "ALTUNTAS", 111044, 562.12, 1992);
    ArrayList<Integer> scores = new ArrayList<>();
    ArrayList<String> matchScheduleAYear = new ArrayList<>();
    ArrayList<Player> plyrs = new ArrayList<Player>();
        
    public TeamTest() {
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
     * Test of toString method, of class Team.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Team instance = new Team("Galatasaray", tcM, "Sari-Kirmizi", prsdnt, plyrs, vice, scores, matchScheduleAYear);
        String expResult = ("Galatasaray" + "\n" 
                      + "President: " + prsdnt.getName() + " " + prsdnt.getSurname() + "\n"
                      + "Vice President: " + vice.getName() + " " + vice.getSurname() + "\n"
                      + "Technical Manager: " + tcM.getName() + " " + tcM.getSurname() + "\n"
                      + "Colors: " + "Sari-Kirmizi");
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of addPlayer method, of class Team.
     */
    @Test
    public void testAddPlayer() {
        System.out.println("addPlayer");
        Team instance = new Team("Galatasaray", tcM, "Sari-Kirmizi", prsdnt, plyrs, vice, scores, matchScheduleAYear);
        instance.addPlayer(plyr);
        assertEquals(instance.getPlayers().get(0), plyr);
    }

    /**
     * Test of deletePlayer method, of class Team.
     */
    @Test
    public void testDeletePlayer() {
        System.out.println("deletePlayer");
        Player pl = new Player("Forvet", "Galatasaray", "Murat", "ALTUNTAS", 111044, 562.12, 1992);
        Team instance = new Team("Galatasaray", tcM, "Sari-Kirmizi", prsdnt, plyrs, vice, scores, matchScheduleAYear);
        instance.addPlayer(pl);
        instance.addPlayer(pl);
        instance.deletePlayer(pl);
        assertEquals(instance.getPlayers().get(instance.getPlayers().size()-1), pl);
    }

    /**
     * Test of changePresident method, of class Team.
     */
    @Test
    public void testChangePresident() {
        System.out.println("changePresident");
        President prsd = new President("Federation", "Vural", "Aysal", 201505, 421.612, 1965);
        Team instance = new Team("Galatasaray", tcM, "Sari-Kirmizi", prsdnt, plyrs, vice, scores, matchScheduleAYear);
        instance.changePresident(prsd);
        assertEquals(instance.getPresident().toString(), prsd.toString());
    }

    /**
     * Test of changeVicePresident method, of class Team.
     */
    @Test
    public void testChangeVicePresident() {
        System.out.println("changeVicePresident");
        VicePresident vcPrsdnt = new VicePresident("Federation", "Vural", "HASAN", 201505, 421.612, 1965);
        Team instance = new Team("Galatasaray", tcM, "Sari-Kirmizi", prsdnt, plyrs, vice, scores, matchScheduleAYear);
        instance.changeVicePresident(vcPrsdnt);
        assertEquals(instance.getVicePresident().toString(), vcPrsdnt.toString());
    }

    /**
     * Test of changeTechnicalManager method, of class Team.
     */
    @Test
    public void testChangeTechnicalManager() {
        System.out.println("changeTechnicalManager");
        TechnicalManager techMngr = new TechnicalManager("Galatasaray", "Hakki", "PASA", 201885, 463.214, 1988);
        Team instance = new Team("Galatasaray", tcM, "Sari-Kirmizi", prsdnt, plyrs, vice, scores, matchScheduleAYear);
        instance.changeTechnicalManager(techMngr);
        assertEquals(instance.getManager().toString(), techMngr.toString());
    }

    /**
     * Test of score method, of class Team.
     */
    @Test
    public void testScore() {
        System.out.println("score");
        ArrayList<Integer> scrs = new ArrayList<>();
        scrs.add(4);
        scrs.add(5);
        Team instance = new Team("Galatasaray", tcM, "Sari-Kirmizi", prsdnt, plyrs, vice, scrs, matchScheduleAYear);
        int expResult = 9;
        int result = instance.score();
        assertEquals(expResult, result);
    }

    /**
     * Test of weeklyScore method, of class Team.
     */
    @Test
    public void testWeeklyScore() {
        System.out.println("weeklyScore");
        int week = 2;
        ArrayList<Integer> score = new ArrayList<>();
        score.add(5);
        score.add(6);
        Team instance = new Team("Galatasaray", tcM, "Sari-Kirmizi", prsdnt, plyrs, vice, score, matchScheduleAYear);
        int expResult = 11;
        int result = instance.weeklyScore(week);
        assertEquals(expResult, result);
    }

    /**
     * Test of searchPlayer method, of class Team.
     */
    @Test
    public void testSearchPlayer() {
        System.out.println("searchPlayer");        
        String pName = "Murat";
        String pSurname = "ALTUNTAS";
        Player plyr = new Player("Forvet", "Galatasaray", pName, pSurname, 111044, 562.12, 1992);        
        Team instance = new Team("Galatasaray", tcM, "Sari-Kirmizi", prsdnt, plyrs, vice, scores, matchScheduleAYear);
        instance.addPlayer(plyr);
        Player expResult = new Player(plyr);
        Player result = instance.searchPlayer(pName, pSurname);
        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of oyuncular method, of class Team.
     */
    @Test
    public void testOyuncular() {
        System.out.println("oyuncular");
        Player plyr = new Player("Forvet", "Galatasaray", "Murat", "ALTUNTAS", 111044, 562.12, 1992);
        Team instance = new Team("Galatasaray", tcM, "Sari-Kirmizi", prsdnt, plyrs, vice, scores, matchScheduleAYear);
        instance.addPlayer(plyr);
        String[] expResult = new String[1];
        expResult[0] = plyr.getName() + " " + plyr.getSurname();
        String[] result = instance.oyuncular();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Team.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Team instance = new Team("Galatasaray", tcM, "Sari-Kirmizi", prsdnt, plyrs, vice, scores, matchScheduleAYear);
        String expResult = "Galatasaray";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Team.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Fenerbahce";
        Team instance = new Team("Galatasaray", tcM, "Sari-Kirmizi", prsdnt, plyrs, vice, scores, matchScheduleAYear);
        instance.setName(name);
        assertEquals(instance.getName(), name);
    }

    /**
     * Test of getManager method, of class Team.
     */
    @Test
    public void testGetManager() {
        System.out.println("getManager");
        Team instance = new Team("Galatasaray", tcM, "Sari-Kirmizi", prsdnt, plyrs, vice, scores, matchScheduleAYear);
        TechnicalManager result = instance.getManager();
        assertEquals(tcM, result);
    }

    /**
     * Test of setManager method, of class Team.
     */
    @Test
    public void testSetManager() {
        System.out.println("setManager");
        TechnicalManager manager = new TechnicalManager("Galatasaray", "Mehmet", "UZUN", 201885, 463.214, 1988);
        Team instance = new Team("Galatasaray", tcM, "Sari-Kirmizi", prsdnt, plyrs, vice, scores, matchScheduleAYear);
        instance.setManager(manager);
        assertEquals(instance.getManager().toString(), manager.toString());
    }

    /**
     * Test of getColor method, of class Team.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        Team instance = new Team("Galatasaray", tcM, "Sari-Kirmizi", prsdnt, plyrs, vice, scores, matchScheduleAYear);
        String expResult = "Sari-Kirmizi";
        String result = instance.getColor();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setColor method, of class Team.
     */
    @Test
    public void testSetColor() {
        System.out.println("setColor");
        String color = "Sari-Kirmizi";
        Team instance = new Team("Galatasaray", tcM, "Sari-Kirmizi", prsdnt, plyrs, vice, scores, matchScheduleAYear);
        instance.setColor(color);
        assertEquals(instance.getColor(), color);
    }

    /**
     * Test of getPresident method, of class Team.
     */
    @Test
    public void testGetPresident() {
        System.out.println("getPresident");
        President expResult = new President("Team", "Ali", "Aysal", 201505, 421.612, 1965);
        Team instance = new Team("Galatasaray", tcM, "Sari-Kirmizi", expResult, plyrs, vice, scores, matchScheduleAYear);
        President result = instance.getPresident();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPresident method, of class Team.
     */
    @Test
    public void testSetPresident() {
        System.out.println("setPresident");
        President president = new President("Team", "Ali", "Aysal", 201505, 421.612, 1965);
        Team instance = new Team("Galatasaray", tcM, "Sari-Kirmizi", prsdnt, plyrs, vice, scores, matchScheduleAYear);
        instance.setPresident(president);
        assertEquals(instance.getPresident().toString(), president.toString());
    }

    /**
     * Test of getPlayers method, of class Team.
     */
    @Test
    public void testGetPlayers() {
        System.out.println("getPlayers");
        ArrayList<Player> expResult = new ArrayList<Player>();
        expResult.add(plyr);
        Team instance = new Team("Galatasaray", tcM, "Sari-Kirmizi", prsdnt, expResult, vice, scores, matchScheduleAYear);
        ArrayList<Player> result = instance.getPlayers();
        System.out.println(expResult.toString());
        System.out.println(result.toString());
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setPlayers method, of class Team.
     */
    @Test
    public void testSetPlayers() {
        System.out.println("setPlayers");
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(plyr);
        Team instance = new Team("Galatasaray", tcM, "Sari-Kirmizi", prsdnt, players, vice, scores, matchScheduleAYear);
        instance.setPlayers(players);
        assertEquals(instance.getPlayers(), players);
    }

    /**
     * Test of getVicePresident method, of class Team.
     */
    @Test
    public void testGetVicePresident() {
        System.out.println("getVicePresident");
        VicePresident expResult = new VicePresident("Team", "Ali", "Aysal", 201505, 421.612, 1965);
        Team instance = new Team("Galatasaray", tcM, "Sari-Kirmizi", prsdnt, plyrs, expResult, scores, matchScheduleAYear);        
        VicePresident result = instance.getVicePresident();
        assertEquals(expResult, result);
    }

    /**
     * Test of setVicePresident method, of class Team.
     */
    @Test
    public void testSetVicePresident() {
        System.out.println("setVicePresident");
        VicePresident vicePresident = new VicePresident("Team", "Ali", "Aysal", 201505, 421.612, 1965);
        Team instance = new Team("Galatasaray", tcM, "Sari-Kirmizi", prsdnt, plyrs, vice, scores, matchScheduleAYear);
        instance.setVicePresident(vicePresident);
        assertEquals(instance.getVicePresident().toString(), vicePresident.toString());
    }

    /**
     * Test of getScores method, of class Team.
     */
    @Test
    public void testGetScores() {
        System.out.println("getScores");
        Team instance = new Team("Galatasaray", tcM, "Sari-Kirmizi", prsdnt, plyrs, vice, scores, matchScheduleAYear);
        ArrayList<Integer> expResult = new ArrayList<>();
        ArrayList<Integer> result = instance.getScores();
        assertEquals(expResult, result);
    }

    /**
     * Test of setScores method, of class Team.
     */
    @Test
    public void testSetScores() {
        System.out.println("setScores");
        ArrayList<Integer> scres = new ArrayList<>();
        Team instance = new Team("Galatasaray", tcM, "Sari-Kirmizi", prsdnt, plyrs, vice, scores, matchScheduleAYear);
        instance.setScores(scores);
        assertEquals(instance.getScores(), scres);        
    }

    /**
     * Test of getMatchScheduleAYear method, of class Team.
     */
    @Test
    public void testGetMatchScheduleAYear() {
        System.out.println("getMatchScheduleAYear");
        Team instance = new Team("Galatasaray", tcM, "Sari-Kirmizi", prsdnt, plyrs, vice, scores, matchScheduleAYear);
        ArrayList<String> expResult = new ArrayList<String>();
        ArrayList<String> result = instance.getMatchScheduleAYear();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMatchScheduleAYear method, of class Team.
     */
    @Test
    public void testSetMatchScheduleAYear() {
        System.out.println("setMatchScheduleAYear");
        ArrayList<String> matchSchedule = new ArrayList<>();
        Team instance = new Team("Galatasaray", tcM, "Sari-Kirmizi", prsdnt, plyrs, vice, scores, matchScheduleAYear);
        instance.setMatchScheduleAYear(matchScheduleAYear);
        assertEquals(instance.getMatchScheduleAYear(), matchSchedule);
    }
    
}
