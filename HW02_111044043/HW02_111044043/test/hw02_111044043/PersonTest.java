package hw02_111044043;

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
public class PersonTest {
    
    public PersonTest() {
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
     * Test of getName method, of class Person.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Person instance = new Person("Murat", "ALTUNTAS", 111044, 19922.152, 1992) {};
        String expResult = "Murat";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Person.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Person instance = new Person("Murat", "ALTUNTAS", 111044, 19922.152, 1992) {};
        instance.setName(name);
        assertEquals(instance.getName(), name);
    }

    /**
     * Test of getSurname method, of class Person.
     */
    @Test
    public void testGetSurname() {
        System.out.println("getSurname");
        Person instance = new Person("Murat", "ALTUNTAS", 111044, 19922.152, 1992) {};
        String expResult = "ALTUNTAS";
        String result = instance.getSurname();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSurname method, of class Person.
     */
    @Test
    public void testSetSurname() {
        System.out.println("setSurname");
        String surname = "ALTUNTAS";
        Person instance = new Person("Murat", "ALTUNTAS", 111044, 19922.152, 1992) {};
        instance.setSurname(surname);
        assertEquals(instance.getSurname(), surname);
    }

    /**
     * Test of getId method, of class Person.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Person instance = new Person("Murat", "ALTUNTAS", 111044, 19922.152, 1992) {};
        int expResult = 111044;
        int result = instance.getId();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setId method, of class Person.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 111044;
        Person instance = new Person("Murat", "ALTUNTAS", 111044, 19922.152, 1992) {};
        instance.setId(id);
        assertEquals(instance.getId(), id);
    }

    /**
     * Test of getSalary method, of class Person.
     */
    @Test
    public void testGetSalary() {
        System.out.println("getSalary");
        Person instance = new Person("Murat", "ALTUNTAS", 111044, 19922.152, 1992) {};
        double expResult = 19922.152;
        double result = instance.getSalary();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setSalary method, of class Person.
     */
    @Test
    public void testSetSalary() {
        System.out.println("setSalary");
        double salary = 19922.152;
        Person instance = new Person("Murat", "ALTUNTAS", 111044, 19922.152, 1992) {};
        instance.setSalary(salary);
        assertEquals(instance.getSalary(), 19922.152, 0.0);
    }

    /**
     * Test of getYearOfBirth method, of class Person.
     */
    @Test
    public void testGetYearOfBirth() {
        System.out.println("getYearOfBirth");
        Person instance = new Person("Murat", "ALTUNTAS", 111044, 19922.152, 1992) {};
        int expResult = 1992;
        int result = instance.getYearOfBirth();
        assertEquals(expResult, result);
    }

    /**
     * Test of setYearOfBirth method, of class Person.
     */
    @Test
    public void testSetYearOfBirth() {
        System.out.println("setYearOfBirth");
        int yearOfBirth = 1992;
        Person instance = new Person("Murat", "ALTUNTAS", 111044, 19922.152, 1992) {};
        instance.setYearOfBirth(yearOfBirth);
        assertEquals(instance.getYearOfBirth(), yearOfBirth);
    }

    public class PersonImpl extends Person {

        public PersonImpl() {
            super(null);
        }
    }
    
}
