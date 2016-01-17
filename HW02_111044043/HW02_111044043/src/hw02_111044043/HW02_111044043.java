/**
 * Murat ALTUNTAŞ
 * 111044043
 * HW02
 * Turkish Football Federation League Automation
 */

package hw02_111044043;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Murat ALTUNTAŞ
 */
public class HW02_111044043 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int year, id, count=0, count2=0;
        double salary;
        String name, surname,locality, teamName,colors;
        String placeOfTheMission; // baskan yada yardimcisinin gorev yeri
        
        ArrayList< ArrayList<Player> > players = new ArrayList<ArrayList<Player>>();
        ArrayList<President> presidents = new ArrayList<President>();
        ArrayList<VicePresident> vicePresidents = new ArrayList<>();
        ArrayList<TechnicalManager> techMans = new ArrayList<>();
        ArrayList<Team> teams = new ArrayList<Team>();
        ArrayList<Integer> scores = new ArrayList<>(); //haftalik puan durumu
        
        File file = new File("players.txt");
        File filePres = new File("president.txt");
        File fileVP = new File("vicePresident.txt");
        File fileTM = new File("teamManager.txt");
        File fileTeam = new File("teams.txt");
        File fileMatchSch = new File("matchSch.txt");
        
        BufferedReader reader = null;
        BufferedReader reader2 = null;
        
        /* Federasyon Baskani */
            President fedP = new President("Federation", "Yildirim", "Demiroren", 191000, 75.525, 1963);
        /* Federasyon Baskan yardimcsi */
            VicePresident fedVP = new VicePresident("Federation", "Servet", "Yardimci", 192000, 64.312, 1969);
            
        try {

            reader = new BufferedReader(new FileReader(file));
            
            /* Player listesi olusturma */
            while(count++ != 18){
                ArrayList<Player> teamPlayers = new ArrayList<Player>();
                while(count2++ != 18){
                    String satir = reader.readLine();
                    String[] parts = satir.split(";");
                    id = Integer.parseInt(parts[0]);
                    name = parts[1];
                    surname = parts[2];
                    salary = Double.parseDouble(parts[3]);
                    year = Integer.parseInt(parts[4]);
                    locality = parts[5];
                    teamName = parts[6];

                    Player player = new Player(locality, teamName, name, surname, id, salary, year);
                    teamPlayers.add(player);
                }
            count2 = 0;
            players.add(teamPlayers);
            }
            
            /* President listesi olusturma */
            count2=0;
            reader = new BufferedReader(new FileReader(filePres));
            while(count2++ != 18){
                    String satir = reader.readLine();
                    String[] parts = satir.split(";");
                    id = Integer.parseInt(parts[0]);
                    name = parts[1];
                    surname = parts[2];
                    salary = Double.parseDouble(parts[3]);
                    year = Integer.parseInt(parts[4]);
                    placeOfTheMission = parts[5];

                    President president = new President(placeOfTheMission, name, surname, id, salary, year);
                    presidents.add(president);
                }
            
            /* VicePresident listesi olusturma */
            count2=0;
            reader = new BufferedReader(new FileReader(fileVP));
            while(count2++ != 18){
                    String satir = reader.readLine();
                    String[] parts = satir.split(";");
                    id = Integer.parseInt(parts[0]);
                    name = parts[1];
                    surname = parts[2];
                    salary = Double.parseDouble(parts[3]);
                    year = Integer.parseInt(parts[4]);
                    placeOfTheMission = parts[5];

                    VicePresident vicePresident = new VicePresident(placeOfTheMission, name, surname, id, salary, year);
                    vicePresidents.add(vicePresident);
                }
            
             /* Technical Manager listesi olusturma */
            count2=0;
            reader = new BufferedReader(new FileReader(fileTM));
            while(count2++ != 18){
                    String satir = reader.readLine();
                    String[] parts = satir.split(";");
                    id = Integer.parseInt(parts[0]);
                    name = parts[1];
                    surname = parts[2];
                    salary = Double.parseDouble(parts[3]);
                    year = Integer.parseInt(parts[4]);
                    teamName = parts[5];

                    TechnicalManager techMan = new TechnicalManager(teamName, name, surname, id, salary, year);
                    techMans.add(techMan);
                }
            
            /* Team listesi olusturma */
            count2=0;
            count=0;
            reader = new BufferedReader(new FileReader(fileTeam));
            reader2 = new BufferedReader(new FileReader(fileMatchSch));
            
            while(count2 != 18){
                ArrayList<Player> teamPlayers2 = new ArrayList<Player>();
                ArrayList<String> matchSchedule = new ArrayList<String>();
                String satir = reader.readLine();
                String[] parts = satir.split(";");
                teamName = parts[0];
                colors = parts[1];
                TechnicalManager manager = new TechnicalManager(techMans.get(count2));
                President prsdnt = new President(presidents.get(count2));
                VicePresident vcPrsdnt = new VicePresident(vicePresidents.get(count2));
                
                String line = reader2.readLine();
                String[] parts2 = line.split(";");
                
                for (int i = 0; i < parts2.length; i++) {
                    matchSchedule.add(parts2[i]);
                }
                
                while(count != 18)
                {
                    teamPlayers2.add(players.get(count2).get(count));
                    ++count;
                }

                Team team = new Team(teamName, manager, colors, prsdnt, teamPlayers2, vcPrsdnt, scores, matchSchedule);
                teams.add(team);
                ++count2;
                count=0;
            }
       
       /* Turkish Football Federation (TFF) */
       Federation federation = new Federation(fedP, fedVP, teams);
       
       StandingTable table1 = new StandingTable(federation);
       table1.setVisible(true);
       
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HW02_111044043.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HW02_111044043.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}
