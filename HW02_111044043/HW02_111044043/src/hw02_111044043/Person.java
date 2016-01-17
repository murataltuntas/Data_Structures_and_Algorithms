/**
 * Murat ALTUNTAŞ
 * 111044043
 * HW02
 * Turkish Football Federation League Automation
 */

package hw02_111044043;

/**
 *
 * @author Murat
 */
public abstract class Person {
    private String name;
    private String surname;
    private int id;
    private double salary;
    private int yearOfBirth; // dogum yili 4 haneli sayi.

    public Person(String name, String surname, int id, double salary, int yearOfBirth) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.salary = salary;
        this.yearOfBirth = yearOfBirth;
    }
    
    /**
     * Copy Constructor
     * @param other 
     */
    public Person(Person other){
        this.name = other.getName();
        this.surname = other.getSurname();
        this.id = other.getId();
        this.salary = other.getSalary();
        this.yearOfBirth = other.getYearOfBirth();
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
     * @return the surname
     */
    public String getSurname() {return surname;}

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {this.surname = surname;}

    /**
     * @return the id
     */
    public int getId() {return id;}
    
    /**
     * @param id the id to set
     */
    public void setId(int id) {this.id = id;}

    /**
     * @return the salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(double salary) {this.salary = salary;}

    /**
     * @return the yearOfBirth
     */
    public int getYearOfBirth() {return yearOfBirth;}

    /**
     * @param yearOfBirth the yearOfBirth to set
     */
    public void setYearOfBirth(int yearOfBirth){this.yearOfBirth = yearOfBirth;} 
}
