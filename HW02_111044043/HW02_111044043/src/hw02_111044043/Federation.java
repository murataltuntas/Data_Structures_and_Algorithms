

package hw02_111044043;

import java.util.ArrayList;

/**
 *
 * @author Murat ALTUNTAŞ
 */
public class Federation {
    private President president;
    private VicePresident vicePresident;
    private ArrayList<Team> teams;

    public Federation(President president, VicePresident vicePresident, ArrayList<Team> teams) {
        this.president = president;
        this.vicePresident = vicePresident;
        //this.teams = teams;
        this.teams = new ArrayList<Team>();
        for (int i = 0; i < teams.size(); i++)
            this.teams.add(teams.get(i));
    }

    /**
     * Copy Constructor
     * @param other 
     */
    public Federation(Federation other)
    {
        president = new President(other.getPresident());
        vicePresident = new VicePresident(other.getVicePresident());
        
        this.teams = new ArrayList<Team>();
        for (int i = 0; i < other.getTeams().size(); i++)
            this.teams.add(other.getTeams().get(i));
    }
    
    @Override
    public String toString(){
        String info = ( getPresident().toString()
                        + getVicePresident().toString());
        return info;
        
    }
    
    /**
     *  Lige taim ekleme
     * @param team 
     */
    public void addTeam(Team team)
    {
        teams.add(team);
    }
    
    /**
     * Ligden takim silme
     * @param team 
     */
    public void deleteTeam(Team team)
    {
        teams.remove(team);
    }
        
    public void changePresident(President prsdnt)
    {
        president = new President(prsdnt);
    }
    
    public void changeVicePresident(VicePresident vcPrsdnt)
    {
        vicePresident = new VicePresident(vcPrsdnt);
    }
    
    /**
     * Bir takimin bir yil boyunca oynayacagi maclar.
     * @param teamName
     * @return 
     */
    public ArrayList<String> matchSchedule(String teamName)
    {
        ArrayList<String> matchSc = new ArrayList<>();
        
        for (int i = 0; i < teams.size(); i++) {
           if(teams.get(i).getName().equals(teamName))
           {
               for (int j = 0; j < teams.get(i).getMatchScheduleAYear().size(); j++) {
                   matchSc.add(teams.get(i).getMatchScheduleAYear().get(j));
               }
               break;
           }
        }
        
        return matchSc;
    }
    
    /**
     * Puan tablosunu ekrana bas.
     * @param week istenilen hafta
     * @return 
     */
    public ArrayList<String> scoresWeekly(int week){
        ArrayList<String> scrs = new ArrayList<String>();
        
        for (int c = 0; c < ( teams.size() - 1 ); c++) {
            for (int d = 0; d < teams.size() - c - 1; d++) {
                if (teams.get(d).weeklyScore(week) < teams.get(d+1).weeklyScore(week))
                {
                  Team swap = new Team(teams.get(d));
                  teams.set(d, teams.get(d+1));
                  teams.set(d+1, swap);
                }
            }
        }
        
        for (int i = 0; i < teams.size(); i++) {
            String scr = (teams.get(i).getName() + "           \t" + teams.get(i).weeklyScore(week));
            scrs.add(scr);
        }
        
        return scrs;
    }
    
    /**
     * O hafta oynanacak maclar
     * @param week 
     * @return  
     */
    public ArrayList<String> standingTableWeekly(int week){
        if(week < 1)
            week = 1;
        if(teams.size() > 0)
            if(week > teams.get(0).getMatchScheduleAYear().size())
                week=teams.get(0).getMatchScheduleAYear().size();
        ArrayList<Team> tmpTeams = new ArrayList<>();
        ArrayList<String> standTable = new ArrayList<String>();
        int j;
                
        for (int i = 0; i < teams.size(); i++) {
            Team temprory = new Team(teams.get(i));
            tmpTeams.add(temprory);
        }
        
        int teamSizeHalf = tmpTeams.size()/2;
        
        for (int i = 0; i < teamSizeHalf; i++) {
            String matchTeam = tmpTeams.get(i).getMatchScheduleAYear().get(week-1);
            standTable.add((tmpTeams.get(i).getName() + "-" + matchTeam));
            
            for (j = 0; j < tmpTeams.size(); j++) {
                if(tmpTeams.get(j).getName().equals(matchTeam) ){       
                    tmpTeams.remove(j);
                    break;
                }
            }
        }
        return standTable;
    }
    
    /**
     * takim adi ile Team arama
     * @param teamName
     * @return 
     */
    public Team searchTeam(String teamName)
    {
        for (int i = 0; i < getTeams().size(); i++) {
            //federation.getTeams().get(i).getName() == teamName
           if(getTeams().get(i).getName().equals(teamName))
           {
               return getTeams().get(i);
           }
        }
        return null;
    }
    
    /**
     * @return the president
     */
    public President getPresident() {return president;}

    /**
     * @param president the president to set
     */
    public void setPresident(President president) {this.president = president;}

    /**
     * @return the vicePresident
     */
    public VicePresident getVicePresident() {return vicePresident;}

    /**
     * @param vicePresident the vicePresident to set
     */
    public void setVicePresident(VicePresident vicePresident) {
        this.vicePresident = vicePresident;
    }

    /**
     * @return the teams
     */
    public ArrayList<Team> getTeams() {return teams;}

    /**
     * @param teams the teams to set
     */
    public void setTeams(ArrayList<Team> teams) {this.teams = teams;}
}
