
package hw02_111044043;

/**
 *
 * @author Murat
 */
public class Player extends Person{
    private String locality;
    private String teamName;

    public Player(String locality, String teamName, String name, String surname, int id, double salary, int yearOfBirth) {
        super(name, surname, id, salary, yearOfBirth);
        this.locality = locality;
        this.teamName = teamName;
    }

    public Player(Player other){
        super(other);
        this.locality = other.getLocality();
        this.teamName = other.getTeamName();
    }
    
    @Override
    public String toString(){
        String info = (getName() + " " + getSurname() + "\n"
                      + "ID: " + getId() + "\n"
                      + "Team: " + getTeamName() + "\n"
                      + "Locality: " + getLocality() + "\n"
                      + "Salary: " + getSalary() + " $" + "\n"
                      + "Year Of Birth: " + getYearOfBirth() + "\n");
        return info;
        
    }
    
    /**
     * @return the locality
     */
    public String getLocality() {
        return locality;
    }
    
    /**
     * @param locality the locality to set
     */
    public void setLocality(String locality) {
        this.locality = locality;
    }

    /**
     * @return the teamName
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * @param teamName the teamName to set
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
