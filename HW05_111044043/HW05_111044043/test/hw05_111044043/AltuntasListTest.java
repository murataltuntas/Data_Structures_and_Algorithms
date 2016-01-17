/**
 * Murat ALTUNTAS
 * 111044043
 * HW04
 * List iterface'inin metodlarinin JUnit Testleri
 */

package hw05_111044043;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
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

public class AltuntasListTest {
    public String [] className = {"Array", "Linked", "Altuntas"}; // yeni bir List extend eden class eklendiginde buraya 
                                                      // ismi eklenir ve o sınıf ListFactory classina da eklenir
    protected int lengthOfList = className.length;    // Listenin uzunlugu
    protected List<Integer> [] emptyList = new List[lengthOfList];
    protected List<Integer> [] ElementsInOrder = new List[lengthOfList];
    protected List<Integer> [] newElements = new List[lengthOfList];
    protected List<Integer> [] newElements2 = new List[lengthOfList];
    protected List<Integer> [] newElements3 = new List[lengthOfList];
    protected Integer nullInteger = null;
    protected List nullList = null;
    
    //public int i=0;  // kaldırmayı unutma ***********************************
    
    public AltuntasListTest() {
        ListFactory listFactory = new ListFactory();
        
        for (int i = 0; i < ElementsInOrder.length; i++) {
            emptyList[i] = listFactory.getList(className[i]);
            ElementsInOrder[i] = listFactory.getList(className[i]);
            newElements[i] = listFactory.getList(className[i]);
            newElements2[i] = listFactory.getList(className[i]);
            newElements3[i] = listFactory.getList(className[i]);

            // elements added to indices 0, 1, 2, 3, 4, in this order
            ElementsInOrder[i].add(0, 16);
            ElementsInOrder[i].add(1, 15);
            ElementsInOrder[i].add(2, 41);
            ElementsInOrder[i].add(3, 21);
            ElementsInOrder[i].add(4, 11);

            //
            newElements[i].add(0,51);
            newElements2[i].add(0,51);        
            newElements3[i].add(0,16);
        }
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

    
    
    /********** Add Test **********/
    @Test
    public void testAdd1() throws IndexOutOfBoundsException {
        for (int i = 0; i < lengthOfList; i++) {
            ElementsInOrder[i].add(new Integer(7));
            assertEquals(new Integer(7), ElementsInOrder[i].get(ElementsInOrder[i].size() - 1));
        }
    } 
    
    @Test 
    public void testAdd2(){
        for (int i = 0; i < lengthOfList; i++)
            assertTrue(ElementsInOrder[i].add(nullInteger));
    }
    
    @Test (expected=NumberFormatException.class)
    public void testAdd3() throws NumberFormatException {
        for (int i = 0; i < lengthOfList; i++) {
            String str = null;
            ElementsInOrder[i].add(Integer.parseInt(str));
        }
    }
    
    @Test (expected = NullPointerException.class)
    public void testAdd4()throws NullPointerException{  
        for (int i = 0; i < lengthOfList; i++){
            nullList.add(new Integer(7));
        }
    }
    
    @Test 
    public void testAdd5(){      
        for (int i = 0; i < lengthOfList; i++) {
            emptyList[i].add(new Integer(7));
            assertEquals(1, emptyList[i].size());
        }
    }
    
    
    /********** Add Index Test **********/   
    
    @Test (expected=NullPointerException.class)
    public void testAddIndex1() throws NullPointerException {
        for (int i = 0; i < lengthOfList; i++) {
            ElementsInOrder[i].add(nullInteger, 15);
        }
    }
    
    @Test (expected=IndexOutOfBoundsException.class)
    public void testAddIndex2() throws IndexOutOfBoundsException {
        for (int i = 0; i < lengthOfList; i++) {
            ElementsInOrder[i].add(ElementsInOrder[i].size() + 1, 8);
        }
    }
    
    @Test (expected=IndexOutOfBoundsException.class)
    public void testAddIndex3() throws IndexOutOfBoundsException {
        for (int i = 0; i < lengthOfList; i++) {
            ElementsInOrder[i].add(-1, 4);
        }
    }
    
    @Test (expected=NumberFormatException.class)
    public void testAddIndex4() throws NumberFormatException {
        for (int i = 0; i < lengthOfList; i++) {
            String str = null;
            ElementsInOrder[i].add(1, Integer.parseInt(str));
        }
    }
   
    @Test
    public void testAddIndex6() {
        for (int i = 0; i < lengthOfList; i++) {
            ElementsInOrder[i].add(0, 15);
            assertEquals(new Integer(15), ElementsInOrder[i].get(0));
        }
    }
    
    @Test (expected = NullPointerException.class)
    public void testAddIndex7() throws NullPointerException{
        for (int i = 0; i < lengthOfList; i++) {
            nullList.add(0, 15);
        }
    }
    
    /********** Add All Test **********/ 
    
    @Test
    public void testAddAll1() { 
        for (int i = 0; i < lengthOfList; i++) {
            assertTrue(ElementsInOrder[i].addAll(newElements[i]));  
        }
    }
    
    @Test
    public void testAddAll2() { 
        for (int i = 0; i < lengthOfList; i++) {
            assertFalse(ElementsInOrder[i].addAll(emptyList[i]));
        }
    }
    
    @Test (expected = NullPointerException.class)
    public void testAddAll3() throws NullPointerException{
        for (int i = 0; i < lengthOfList; i++) {
            assertTrue(ElementsInOrder[i].addAll(null));
        }
    }
    
    @Test (expected = NullPointerException.class)
    public void testAddAll4() throws NullPointerException{   
        for (int i = 0; i < lengthOfList; i++) {
            assertTrue(nullList.addAll(newElements[i]));  
        }
    }
    
    /********** Add All Index Test **********/ 
    
    // Null bir yere ekleyemez
    @Test (expected = NullPointerException.class)
    public void testAddAllIndex1() throws NullPointerException {
        for (int i = 0; i < lengthOfList; i++) {
            assertTrue(ElementsInOrder[i].addAll(nullInteger,newElements[i]));  
        }
    }
    
    // size disina ekleyemez
    @Test (expected=IndexOutOfBoundsException.class)
    public void testAddAllIndex2() throws IndexOutOfBoundsException {
        for (int i = 0; i < lengthOfList; i++) {
            assertTrue(ElementsInOrder[i].addAll(ElementsInOrder[i].size() + 1, newElements[i]));
        }
    }
    
    // negatif indexe ekleyemez
    @Test (expected=IndexOutOfBoundsException.class)
    public void testAddAllIndex3() throws IndexOutOfBoundsException {
        for (int i = 0; i < lengthOfList; i++) {
            assertTrue(ElementsInOrder[i].addAll(-1, newElements[i]));
        }
    }
    
    // null bir List ekleyemez
    @Test (expected = NullPointerException.class)
    public void testAddAllIndex4() throws NullPointerException{   
        for (int i = 0; i < lengthOfList; i++) {
            assertTrue(ElementsInOrder[i].addAll(0,null));        
        }
    }
    
    // ilk elemana ekler
    @Test
    public void testAddAllIndex5() {        
        for (int i = 0; i < lengthOfList; i++) {
            assertTrue(ElementsInOrder[i].addAll(0,newElements[i])); 
        }
    }
    
    // null listeye ekleme
    @Test (expected = NullPointerException.class)
    public void testAddAllIndex6() throws NullPointerException{    
        for (int i = 0; i < lengthOfList; i++) {
            assertTrue(nullList.addAll(0,newElements[i]));
        }
    }
    
    /********** Clear Test **********/ 
    
    @Test
    public void testClear1(){
        for (int i = 0; i < lengthOfList; i++) {
            ElementsInOrder[i].clear();
            assertEquals(0, ElementsInOrder[i].size());
        }
    }
    
    @Test
    public void testClear2(){
        for (int i = 0; i < lengthOfList; i++) {
            ElementsInOrder[i].clear();
            assertTrue(ElementsInOrder[i].isEmpty());
        }
    }
    
    @Test
    public void testClear3(){
        for (int i = 0; i < lengthOfList; i++) {
            ElementsInOrder[i].clear();
            ElementsInOrder[i].add(5);
            assertEquals(1, ElementsInOrder[i].size());
        }
    }
    
    @Test (expected = NullPointerException.class)
    public void testClear4() throws NullPointerException{
        for (int i = 0; i < lengthOfList; i++) {
            nullList.clear();
        }
    }
    
    /********** Contains Test **********/ 
    
    // Listede 1  yok
    @Test
    public void testContains1() {
        for (int i = 0; i < lengthOfList; i++) {
            assertFalse(emptyList[i].contains(1));
        }
    }
    
    @Test
    public void testContains2() {
        for (int i = 0; i < lengthOfList; i++) {
            assertTrue(ElementsInOrder[i].contains(21));
        }
    }
    
    @Test
    public void testContains3() {
        for (int i = 0; i < lengthOfList; i++) {
            assertFalse(ElementsInOrder[i].contains(null));
        }
    }
    
    @Test
    public void testContains4() {
        for (int i = 0; i < lengthOfList; i++) {
            assertFalse(ElementsInOrder[i].contains('a'));
        }
    }
    
    @Test
    public void testContains5() {
        for (int i = 0; i < lengthOfList; i++) {
            assertFalse(ElementsInOrder[i].contains(5.2));
        }
    }
    
    @Test (expected = NullPointerException.class)
    public void testContains6() throws NullPointerException{
        for (int i = 0; i < lengthOfList; i++) {
            assertFalse(nullList.contains(5.2));
        }
    }
    
    /********** Contains All Test **********/ 
        
    @Test
    public void testContainsAll1() {
        for (int i = 0; i < lengthOfList; i++) {
            assertFalse(emptyList[i].containsAll(newElements[i]));
        }
    }
  
    @Test (expected = NullPointerException.class)
    public void testContainsAll2() throws NullPointerException{
        for (int i = 0; i < lengthOfList; i++) {
            assertTrue(ElementsInOrder[i].containsAll(null));
        }
    }
    
    @Test
    public void testContainsAll3(){
        for (int i = 0; i < lengthOfList; i++) {
            assertTrue(ElementsInOrder[i].containsAll(emptyList[i]));
        }
    }
    
    @Test (expected = NullPointerException.class)
    public void testContainsAll4()throws NullPointerException{
        for (int i = 0; i < lengthOfList; i++) {
            assertTrue(nullList.containsAll(emptyList[i]));
        }
    }
    
    /********** Equal Test **********/ 
    
    @Test
    public void testEqual1(){
        for (int i = 0; i < lengthOfList; i++) {
            assertTrue(ElementsInOrder[i].get(0).equals(16));
        }
    }
    
    @Test
    public void testEqual2(){
        for (int i = 0; i < lengthOfList; i++) {
            assertFalse(ElementsInOrder[i].get(1).equals(16));
        }
    }
    
    @Test
    public void testEqual3(){
        for (int i = 0; i < lengthOfList; i++) {
            assertFalse(ElementsInOrder[i].equals(null));
        }
    }
    
    @Test (expected = NullPointerException.class)
    public void testEqual4() throws NullPointerException{
        for (int i = 0; i < lengthOfList; i++) {
            assertTrue(nullList.equals(null));
        }
    }
    
    @Test
    public void testEqual5(){
        for (int i = 0; i < lengthOfList; i++) {
            assertTrue(ElementsInOrder[i].equals(ElementsInOrder[i]));
        }
    }
    
    /********** Get Test **********/    
    
    @Test
    public void testGet1() {
        for (int i = 0; i < lengthOfList; i++) {
            Integer expResult = new Integer(16);
            assertEquals(ElementsInOrder[i].get(0), expResult);
        }
    }
    
    @Test
    public void testGet2() {
        for (int i = 0; i < lengthOfList; i++) {
            Integer expResult = new Integer(15);
            assertEquals(ElementsInOrder[i].get(1), expResult);
        }
    }
    
    @Test
    public void testGet3() throws IndexOutOfBoundsException {
        for (int i = 0; i < lengthOfList; i++) {
            Integer expResult = new Integer(41);
            assertEquals(ElementsInOrder[i].get(2), expResult);
        }
    }
    
    // test Exception Get Negative
    @Test (expected=IndexOutOfBoundsException.class)
    public void testGet4() throws IndexOutOfBoundsException {
        for (int i = 0; i < lengthOfList; i++) {
            ElementsInOrder[i].get(-1);
        }
    }
    
    // Index Out Of Bounds Exception
    @Test (expected=IndexOutOfBoundsException.class)
    public void testGet5() throws IndexOutOfBoundsException {
        for (int i = 0; i < lengthOfList; i++) {
            ElementsInOrder[i].get(ElementsInOrder[i].size());
        }
    }
    
    @Test (expected = NullPointerException.class)
    public void testGet6() throws NullPointerException {
        for (int i = 0; i < lengthOfList; i++) {
            Integer expResult = new Integer(15);
            assertEquals(nullList.get(0), expResult);
        }
    }
    
    /********** HashCode Test **********/ 
    
    @Test
    public void testHashCode1() {
        for (int i = 0; i < lengthOfList; i++) {
            assertTrue(newElements[i].hashCode() == newElements2[i].hashCode());
        }
    }
        
    @Test
    public void testHashCode2() {
        for (int i = 0; i < lengthOfList; i++) {
            assertTrue(newElements[i].hashCode() != ElementsInOrder[i].hashCode());
        }
    }

    @Test (expected = NullPointerException.class)
    public void testHashCode3() throws NullPointerException{
        for (int i = 0; i < lengthOfList; i++) {
            assertTrue(nullList.hashCode() == 0);
        }
    }
    
    /********** IndexOf Test **********/
    
    @Test
    public void testIndexOf1() {
        for (int i = 0; i < lengthOfList; i++) {
            assertEquals(0,ElementsInOrder[i].indexOf(ElementsInOrder[i].get(0)));
        }
    }
        
    //eleman yoksa -1 doner
    @Test
    public void testIndexOf2() {    
        for (int i = 0; i < lengthOfList; i++) {
            assertEquals(-1,ElementsInOrder[i].indexOf(444));
        }
    }
    
    @Test
    public void testIndexOf3() {     
        for (int i = 0; i < lengthOfList; i++) {
            assertEquals(-1,ElementsInOrder[i].indexOf(null));
        }
    }
    
    @Test (expected = NullPointerException.class)
    public void testIndexOf4() throws NullPointerException{
        for (int i = 0; i < lengthOfList; i++) {
            assertEquals(-1,nullList.indexOf(0));
        }
    }
    
    /********** isEmpty Test **********/
    
    @Test
    public void testIsEmpty1() {
        for (int i = 0; i < lengthOfList; i++) {
            assertTrue(emptyList[i].isEmpty());
        }
    }
    
    @Test
    public void testIsEmpty2() {
        for (int i = 0; i < lengthOfList; i++) {
            assertEquals(0,emptyList[i].size());
        }
    }
    
    @Test
    public void testIsEmpty3() {
        for (int i = 0; i < lengthOfList; i++) {
            assertFalse(ElementsInOrder[i].isEmpty());
        }
    }
    
    @Test (expected = NullPointerException.class)
    public void testIsEmpty4() throws NullPointerException{
        for (int i = 0; i < lengthOfList; i++) {
            assertTrue(nullList.isEmpty());
        }
    }
    
    /********** Iterator and ListIterator Test **********/
    
    @Test
    public void testIterator1() {
        for (int i = 0; i < lengthOfList; i++) {
            int count;
            Iterator<Integer> iter = ElementsInOrder[i].iterator();
            Integer testValue = new Integer(0);

            for (count = 0; iter.hasNext(); ++count) {
                    testValue = iter.next();
            }

            int expected = ElementsInOrder[i].size();
            int result = count;
            assertEquals(expected, result);
        }
    }
/*
    // Add After Next
    @Test
    public void testIterator2() {
        for (int i = 0; i < lengthOfList; i++) {
            ListIterator<Integer> it = ElementsInOrder[i].listIterator();
            it.next();
            it.add(new Integer(5));
            assertTrue(ElementsInOrder[i].get(1).equals(new Integer(5)));
        }
    }
    */
    // Has Previous None
    @Test
    public void testIterator2() {
        for (int i = 0; i < lengthOfList; i++) {
            ListIterator<Integer> it = ElementsInOrder[i].listIterator();
		assertFalse(it.hasPrevious());
        }
    }
    
    // Has Previous
    @Test
    public void testIterator3() {
        for (int i = 0; i < lengthOfList; i++) {
            ListIterator<Integer> it = ElementsInOrder[i].listIterator();
		it.next();
		assertTrue(it.previous() != null);
        }
    }
    /*
    // Add After Previous
    @Test
    public void testIterator5() {
        for (int i = 0; i < lengthOfList; i++) {
            ListIterator<Integer> it = ElementsInOrder[i].listIterator();
            it.next();
            it.next();
            it.previous();
            it.add(new Integer(5));
            assertTrue(ElementsInOrder[i].get(1).equals(new Integer(5)));
        }
    }
    */
    // Next
    @Test
    public void testIterator4() {
        for (int i = 0; i < lengthOfList; i++) {
            ListIterator<Integer> it = ElementsInOrder[i].listIterator();
            while (it.hasNext())
		assertTrue(it.next() != null);
        }
    }
    
    // hasNext Index Size
    @Test
    public void testIterator5() {
        for (int i = 0; i < lengthOfList; i++) {
            ListIterator<Integer> it = ElementsInOrder[i].listIterator();
            while (it.hasNext()) {
                    it.next();
            }
            assertTrue(it.nextIndex() == ElementsInOrder[i].size());
        }
    }
    
    // PreviousEx
    @Test (expected = NoSuchElementException.class)
    public void testIterator6() throws NoSuchElementException{
        for (int i = 0; i < lengthOfList; i++) {
            ListIterator<Integer> it = ElementsInOrder[i].listIterator();
            it.previous();
        }        
    }
    
    
    /********** LastIndexOf Test **********/  
    
    @Test
    public void testLastIndexOf1() {
        for (int i = 0; i < lengthOfList; i++) {
            assertEquals(-1,emptyList[i].lastIndexOf(0));
        }
    }
    
    @Test
    public void testLastIndexOf2() {
        for (int i = 0; i < lengthOfList; i++) {
            assertEquals(0,ElementsInOrder[i].lastIndexOf(16));
        }
    }
    
    @Test
    public void testLastIndexOf3() {
        for (int i = 0; i < lengthOfList; i++) {
            assertEquals(-1,ElementsInOrder[i].lastIndexOf(null));
        }
    }
    
    @Test (expected = NullPointerException.class)
    public void testLastIndexOf4() throws NullPointerException{
        for (int i = 0; i < lengthOfList; i++) {
            assertEquals(-1,nullList.lastIndexOf(0));
        }
    }
    
    /********** RemoveIndex Test **********/
    
    @Test
    public void testRemoveIndex1() {
        for (int i = 0; i < lengthOfList; i++) {
            int size = ElementsInOrder[i].size();
            ElementsInOrder[i].remove(0);
            assertEquals(size-1, ElementsInOrder[i].size());
        }
    }
    
    @Test
    public void testRemoveIndex2() {
        for (int i = 0; i < lengthOfList; i++) {
            int size = ElementsInOrder[i].size();
            for (int j = 0; j < size; j++) {
                ElementsInOrder[i].remove(0);
            }
            assertEquals(0, ElementsInOrder[i].size());
        }
    }
    
    @Test
    public void testRemoveIndex3() {
        for (int i = 0; i < lengthOfList; i++) {
            int size = ElementsInOrder[i].size();
            for (int j = 0; j < size; j++) {
                ElementsInOrder[i].remove(0);
            }        
            assertTrue(ElementsInOrder[i].isEmpty());
        }
    }

    @Test (expected=IndexOutOfBoundsException.class)
    public void testRemoveIndex4() throws IndexOutOfBoundsException {
        for (int i = 0; i < lengthOfList; i++) {
            emptyList[i].remove(0);
        }
    }
    
    @Test (expected=IndexOutOfBoundsException.class)
    public void testRemoveIndex5() throws IndexOutOfBoundsException {
        for (int i = 0; i < lengthOfList; i++) {
            ElementsInOrder[i].remove(ElementsInOrder[i].size());
        }
    }
    
    @Test (expected=IndexOutOfBoundsException.class)
    public void testRemoveIndex6() throws IndexOutOfBoundsException {
        for (int i = 0; i < lengthOfList; i++) {
            ElementsInOrder[i].remove(-1);
        }
    }
    
    @Test (expected=NullPointerException.class)
    public void testRemoveIndex7() throws NullPointerException {
        for (int i = 0; i < lengthOfList; i++) {
            nullList.remove(0);
        }
    }
    
    /********** Remove Test **********/
   
    @Test
    public void testRemove1() {
        for (int i = 0; i < lengthOfList; i++) {
            Integer first = ElementsInOrder[i].get(1);
            ElementsInOrder[i].remove(ElementsInOrder[i].get(0));
            assertEquals(first, ElementsInOrder[i].get(0));
        }
    }
    
    @Test
    public void testRemove2() {
        for (int i = 0; i < lengthOfList; i++) {
            Integer first = ElementsInOrder[i].get(0);
            ElementsInOrder[i].remove(ElementsInOrder[i].get(0));
            assertNotSame(first, ElementsInOrder[i].get(0));
        }
    }
    
    @Test
    public void testRemove3() {
        for (int i = 0; i < lengthOfList; i++) {
            ElementsInOrder[i].remove(nullInteger);
        }
    }
    
    @Test
    public void testRemove4() {
        for (int i = 0; i < lengthOfList; i++) {
            Object num = new String("444");
            ElementsInOrder[i].remove(num);
        }
    }
    
    @Test
    public void testRemove5(){
        for (int i = 0; i < lengthOfList; i++) {
            int size = ElementsInOrder[i].size();
            ElementsInOrder[i].remove(ElementsInOrder[i].get(ElementsInOrder[i].size()-1));
            assertEquals(size-1, ElementsInOrder[i].size());
        }
    }
    
    @Test (expected = NullPointerException.class)
    public void testRemove6() throws NullPointerException {
        for (int i = 0; i < lengthOfList; i++) {
            nullList.remove(nullInteger);
        }
    }
    
    /********** Remove All Test **********/
    
    // olamayan listeyi silme
    @Test
    public void testRemoveAll1(){
        for (int i = 0; i < lengthOfList; i++) {        
            assertFalse(ElementsInOrder[i].removeAll(newElements[i]));
        }
    }
    
    // null silme
    @Test (expected = NullPointerException.class)
    public void testRemoveAll2() throws NullPointerException {
        for (int i = 0; i < lengthOfList; i++) {
            assertFalse(ElementsInOrder[i].removeAll(null));
        }
    }
    
    // bos liste silme
    @Test
    public void testRemoveAll3(){
        for (int i = 0; i < lengthOfList; i++) {
            assertFalse(ElementsInOrder[i].removeAll(emptyList[i]));
        }
    }
    
    @Test
    public void testRemoveAll4(){
        for (int i = 0; i < lengthOfList; i++) {
            assertTrue(ElementsInOrder[i].removeAll(newElements3[i]));
        }
    }
    
    @Test (expected = NullPointerException.class)
    public void testRemoveAll5() throws NullPointerException {
        for (int i = 0; i < lengthOfList; i++) {
            assertTrue(nullList.removeAll(newElements3[i]));
        }
    }
    
    /********** RetainAll Test **********/
            
    @Test
    public void testRetainAll1(){
        for (int i = 0; i < lengthOfList; i++) {
            ElementsInOrder[i].retainAll(newElements[i]);
            assertEquals(0,ElementsInOrder[i].size());
        }
    }
    
    @Test (expected = NullPointerException.class)
    public void testRetainAll2() throws NullPointerException {
        for (int i = 0; i < lengthOfList; i++) {
            assertFalse(ElementsInOrder[i].retainAll(null));
        }
    }
    
    @Test
    public void testRetainAll3(){
        for (int i = 0; i < lengthOfList; i++) {
            assertTrue(ElementsInOrder[i].retainAll(emptyList[i]));
        }
    }
    
    @Test
    public void testRetainAll4(){
        for (int i = 0; i < lengthOfList; i++) {
            ElementsInOrder[i].retainAll(newElements3[i]);
            assertEquals(1,ElementsInOrder[i].size());
        }
    }
    
    @Test (expected = NullPointerException.class)
    public void testRetainAll5() throws NullPointerException {
        for (int i = 0; i < lengthOfList; i++) {
            assertTrue(nullList.retainAll(newElements3[i]));
        }
    }
    
    /********** Set Test **********/
    
    @Test
    public void testSet1() {
        for (int i = 0; i < lengthOfList; i++) {
            ElementsInOrder[i].set(0, new Integer(111));
            assertEquals(new Integer(111),ElementsInOrder[i].get(0));
        }
    }
    
    @Test (expected = IndexOutOfBoundsException.class)
    public void testSet2() throws IndexOutOfBoundsException{
        for (int i = 0; i < lengthOfList; i++) {
            ElementsInOrder[i].set(ElementsInOrder[i].size()+1, new Integer(111));
        }
    }
    
    @Test (expected = NullPointerException.class)
    public void testSet3() throws NullPointerException{
        for (int i = 0; i < lengthOfList; i++) {
            nullList.set(0, new Integer(111));
            assertEquals(new Integer(111),nullList.get(0));
        }
    }
    
    @Test (expected = IndexOutOfBoundsException.class)
    public void testSet4() throws IndexOutOfBoundsException {
        for (int i = 0; i < lengthOfList; i++) {
            ElementsInOrder[i].set(-1, new Integer(111));
        }
    }
    
    /********** Size Test **********/
    
    @Test
    public void testSize1(){
        for (int i = 0; i < lengthOfList; i++) {
            assertEquals(0,emptyList[i].size());
        }
    }
    
    @Test
    public void testSize2() {
        for (int i = 0; i < lengthOfList; i++) {
            assertEquals(5,ElementsInOrder[i].size());
        }
    }
    
    @Test
    public void testSize3() {
        for (int i = 0; i < lengthOfList; i++) {
            assertNotSame(-1,ElementsInOrder[i].size());
        }
    }
    
    @Test (expected = NullPointerException.class)
    public void testSize4()throws NullPointerException{
        for (int i = 0; i < lengthOfList; i++) {
            assertEquals(0,nullList.size());
        }
    }
    
    /********** SubList Test **********/
    
    @Test
    public void testSubList1(){
        for (int i = 0; i < lengthOfList; i++) {
            assertEquals(new Integer(41), ElementsInOrder[i].subList(2, 4).get(0));
        }
    }
    
    @Test (expected = IndexOutOfBoundsException.class)
    public void testSubList2()throws IndexOutOfBoundsException{
        for (int i = 0; i < lengthOfList; i++) {
            assertEquals(0, ElementsInOrder[i].subList(-1, 1));
        }
    }
    
    @Test (expected = IndexOutOfBoundsException.class)
    public void testSubList3()throws IndexOutOfBoundsException {
        for (int i = 0; i < lengthOfList; i++) {
            assertEquals(0, emptyList[i].subList(0, 1));
        }
    }
    
    @Test (expected = NullPointerException.class)
    public void testSubList4()throws NullPointerException{
        for (int i = 0; i < lengthOfList; i++) {
            assertEquals(0, nullList.subList(0, 1));
        }
    }
    
    @Test
    public void testSubList5(){
        for (int i = 0; i < lengthOfList; i++) {
            assertEquals(ElementsInOrder[i], ElementsInOrder[i].subList(0, ElementsInOrder[i].size()));
        }
    }
    
    /********** toArray Test **********/
    
    @Test
    public void testSToArray1(){
        for (int i = 0; i < lengthOfList; i++) {
            Integer list2[] = new Integer[ElementsInOrder[i].size()];
            list2 = ElementsInOrder[i].toArray(list2);
            for (int number=0; number < list2.length; number++) {
                assertEquals(list2[number], ElementsInOrder[i].get(number));
            }        
        }
    }
    
    @Test
    public void testSToArray2(){
        for (int i = 0; i < lengthOfList; i++) {
            Integer[] result = ElementsInOrder[i].toArray(new Integer[0]);
            assertEquals(result.length, ElementsInOrder[i].size());
        }
    }
    
    @Test
    public void testSToArray3(){
        for (int i = 0; i < lengthOfList; i++) {
            Integer list2[] = new Integer[emptyList[i].size()];
            list2 = emptyList[i].toArray(list2);
            for (int number=0; number < list2.length; number++) {
                assertEquals(list2[number], emptyList[i].get(number));
            }
        }
    }
    
    @Test (expected = NullPointerException.class)
    public void testSToArray4()throws NullPointerException{
        for (int i = 0; i < lengthOfList; i++) {
            Integer list2[] = new Integer[0];
            list2 = (Integer[]) nullList.toArray(list2);
            for (int number=0; number < list2.length; number++) {
                assertEquals(list2[number], nullList.get(number));
            }     
        }
    }
    
    @Test (expected = ArrayStoreException.class)
    public void testSToArray5()throws ArrayStoreException{
        for (int i = 0; i < lengthOfList; i++) {
            Object[] result = ElementsInOrder[i].toArray(new String[0]);
            result[0] = new Integer(0);
        }
                
    }
    
    @Test
    public void testSToArray6(){
        for (int i = 0; i < lengthOfList; i++) {
            Object[] array = ElementsInOrder[i].toArray();
            for (Object num : array) {
                assertTrue(null != num);
            }
        }
    }
}
