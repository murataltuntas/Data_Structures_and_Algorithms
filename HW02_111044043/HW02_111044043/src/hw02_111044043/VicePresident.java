/**
 * Murat ALTUNTAŞ
 * 111044043
 * HW02
 * Turkish Football Federation League Automation
 */

package hw02_111044043;

/**
 *
 * @author Murat ALTUNTAŞ
 */
public class VicePresident extends Person{
    private String placeOfTheMission; // Federation or Team

    public VicePresident(String placeOfTheMission, String name, String surname, int id, double salary, int yearOfBirth) {
        super(name, surname, id, salary, yearOfBirth);
        this.placeOfTheMission = placeOfTheMission;
    }

    /**
     * Copy constructor
     * @param other 
     */
    public VicePresident(VicePresident other){
        super(other);
        this.placeOfTheMission = other.getPlaceOfTheMission();
    }
    /**
     * @return the placeOfTheMission
     */
    public String getPlaceOfTheMission() {return placeOfTheMission;}

    /**
     * @param placeOfTheMission the placeOfTheMission to set
     */
    public void setPlaceOfTheMission(String placeOfTheMission){
        this.placeOfTheMission = placeOfTheMission;
    }
    
    @Override
    public String toString(){
        String info = (getName() + " " + getSurname() + "\n"
                      + "ID: " + getId() + "\n"
                      + "Salary: " + getSalary() + " $" + "\n"
                      + "Year Of Birth: " + getYearOfBirth() + "\n"
                      + "Place of The Mission: " + getPlaceOfTheMission() + "\n\n");
        return info;
    }
}
