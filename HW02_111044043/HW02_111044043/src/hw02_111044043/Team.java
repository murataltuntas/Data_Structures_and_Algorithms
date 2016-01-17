package hw02_111044043;

import java.util.ArrayList;

/**
 *
 * @author Murat
 */
public class Team {
    private String name;
    private TechnicalManager manager;
    private String color;
    private President president;
    private VicePresident vicePresident;
    private ArrayList<Player> players; // takim oyunculari
    private ArrayList<Integer> scores; // haftalik puan durumu
    private ArrayList<String> matchScheduleAYear; // takimin bir yillik mac programi
    
    public Team(String name, TechnicalManager manager, String color, President president, ArrayList<Player> players, VicePresident vicePresident, ArrayList<Integer> scores, ArrayList<String> matchScheduleAYear) {
        this.name = name;
        this.manager = manager;
        this.color = color;
        this.president = president;
        this.vicePresident = vicePresident;
        //this.players = players;
        this.players = new ArrayList<Player>();
        this.players.clear();
        for (int i = 0; i < players.size(); i++)
            this.players.add(players.get(i));
        //this.scores = scores;
        this.scores = new ArrayList<Integer>();
        for (int i = 0; i < scores.size(); i++)
            this.scores.add(scores.get(i));
        //this.matchScheduleAYear = matchScheduleAYear;
        this.matchScheduleAYear = new ArrayList<String>();
        for (int i = 0; i < matchScheduleAYear.size(); i++)
            this.matchScheduleAYear.add(matchScheduleAYear.get(i));
    }
    
    public Team(Team other)
    {
        name = other.getName();
        color = other.getColor();
        manager = new TechnicalManager(other.getManager());
        president = new President(other.getPresident());
        vicePresident = new VicePresident(other.getVicePresident());
        
        this.players = new ArrayList<Player>();
        this.players.clear();
   //System.out.println("oyuncularin sayisi: " + other.getPlayers().size());
        for (int i = 0; i < other.getPlayers().size(); i++)
            this.players.add(other.getPlayers().get(i));
        
        this.scores = new ArrayList<Integer>();
        for (int i = 0; i < other.getScores().size(); i++)
            this.scores.add(other.getScores().get(i));
        
        this.matchScheduleAYear = new ArrayList<String>();
        for (int i = 0; i < other.getMatchScheduleAYear().size(); i++)
            this.matchScheduleAYear.add(other.getMatchScheduleAYear().get(i));
    }

    @Override
    public String toString(){
        String info = (getName() + "\n" 
                      + "President: " + getPresident().getName() + " " + getPresident().getSurname() + "\n"
                      + "Vice President: " + getVicePresident().getName() + " " + getVicePresident().getSurname() + "\n"
                      + "Technical Manager: " + getManager().getName() + " " + getManager().getSurname() + "\n"
                      + "Colors: " + getColor());
        return info;
        
    }
    /**
     * add player
     * @param plyr new Player
     */
    public void addPlayer(Player plyr)
    {
        players.add(plyr);
    }
    
    public void deletePlayer(Player plyr)
    {
        players.remove(plyr);
    }
    
    public void changePresident(President prsdnt)
    {
        president = new President(prsdnt);
    }
    
    public void changeVicePresident(VicePresident vcPrsdnt)
    {
        vicePresident = new VicePresident(vcPrsdnt);
    }
    
    public void changeTechnicalManager(TechnicalManager techMngr)
    {
        manager = new TechnicalManager(techMngr);
    }
    
    /**
     * bir takimin Sezon boyunca aldigi puan toplami
     * @return 
     */
    public int score()
    {
        int total=0;
        for (int i = 0; i < scores.size(); i++) {
            total += scores.get(i);
        }
        return total;
    }
    
    /**
     * bir takimin o haftaya kadar ki aldigi puan toplami
     * @param week
     * @return 
     */
    public int weeklyScore(int week)
    {
        int total=0;
        int hafta;
        
        if (week >= scores.size()) 
            hafta = scores.size();
        else
            hafta = week;
        
        for (int i = 0; i < hafta; i++) {
            total += scores.get(i);
        }
        return total;
    }
    
    /**
     * Player arama fonksiyonu
     * @param pName
     * @param pSurname
     * @return 
     */
    public Player searchPlayer(String pName, String pSurname)
    {
        for (int i = 0; i < getPlayers().size(); i++) {
            //federation.getTeams().get(i).getName() == teamName
           if(getPlayers().get(i).getName().equals(pName) && getPlayers().get(i).getSurname().equals(pSurname))
           {
               return getPlayers().get(i);
           }
        }
        return null;
    }
    
    public String[] oyuncular(){
        String [] tms = new String[getPlayers().size()];
        for (int i = 0; i < getPlayers().size(); i++) {
            tms[i] = getPlayers().get(i).getName() + " " + getPlayers().get(i).getSurname();
        }
        return tms;
    }
    
    /**
     * @return the name
     */
    public String getName() {return name;}

    /**
     * @param name the name to set
     */
    public void setName(String name) {this.name = name;}

    /**
     * @return the manager
     */
    public TechnicalManager getManager() {return manager;}

    /**
     * @param manager the manager to set
     */
    public void setManager(TechnicalManager manager) {
        this.manager = new TechnicalManager(manager);
    }

    /**
     * @return the color
     */
    public String getColor() {return color;}

    /**
     * @param color the color to set
     */
    public void setColor(String color) {this.color = color;}

    /**
     * @return the president
     */
    public President getPresident() {
        return president;
    }

    /**
     * @param president the president to set
     */
    public void setPresident(President president) {
        this.president = new President(president);
    }

    /**
     * @return the players
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players to set
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * @return the vicePresident
     */
    public VicePresident getVicePresident() {
        return vicePresident;
    }

    /**
     * @param vicePresident the vicePresident to set
     */
    public void setVicePresident(VicePresident vicePresident) {
        this.vicePresident = new VicePresident(vicePresident);
    }

    /**
     * @return the scores
     */
    public ArrayList<Integer> getScores() {
        return scores;
    }

    /**
     * @param scores the scores to set
     */
    public void setScores(ArrayList<Integer> scores) {
        this.scores = scores;
    }

    /**
     * @return the matchScheduleAYear
     */
    public ArrayList<String> getMatchScheduleAYear() {
        return matchScheduleAYear;
    }

    /**
     * @param matchScheduleAYear the matchScheduleAYear to set
     */
    public void setMatchScheduleAYear(ArrayList<String> matchScheduleAYear) {
        this.matchScheduleAYear = matchScheduleAYear;
    }
}
