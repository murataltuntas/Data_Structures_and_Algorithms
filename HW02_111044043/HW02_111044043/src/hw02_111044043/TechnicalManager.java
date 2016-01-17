/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hw02_111044043;

/**
 *
 * @author Murat
 */
public class TechnicalManager extends Person{
    private String teamName;

    public TechnicalManager(String teamName, String name, String surname, int id, double salary, int yearOfBirth) {
        super(name, surname, id, salary, yearOfBirth);
        this.setTeamName(teamName);
    }

    /**
     * Copy Constructor
     * @param other 
     */
    public TechnicalManager(TechnicalManager other){
        super(other);
        this.setTeamName(other.getTeamName());
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
    
    @Override
    public String toString(){
        String info = (getName() + " " + getSurname() + "\n"
                      + "ID: " + getId() + "\n"
                      + "Salary: " + getSalary() + " $" + "\n"
                      + "Year Of Birth: " + getYearOfBirth() + "\n"
                      + "Team: " + getTeamName()+ "\n\n");
        return info;
    }
}
