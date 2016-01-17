package hw06_111044043;

import java.util.Iterator;
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
public class testMyPriorityQueue{

    protected MyPriorityQueue<Integer> emptyList = new MyPriorityQueue();
    protected MyPriorityQueue<Integer> Elements = new MyPriorityQueue();
    protected MyPriorityQueue<Integer> newElements = new MyPriorityQueue();
    protected MyPriorityQueue<Integer> newElements2 = new MyPriorityQueue();
    protected MyPriorityQueue<Integer> newElements3 = new MyPriorityQueue();
    protected Integer nullInteger = null;
    protected MyPriorityQueue nullList = null;
    
    public testMyPriorityQueue() {
            // elements added 
            Elements.add(11);
            Elements.add(21);
            Elements.offer(13);
            Elements.offer(15);
            Elements.add(18);
            Elements.add(7);
            Elements.offer(4);
            Elements.offer(16);
            //
            newElements.add(51);
            newElements2.add(51);        
            newElements3.add(16);
        
        
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
        Elements.add(new Integer(2));
        assertEquals(new Integer(2), Elements.peek());
    } 
    
    @Test  (expected = NullPointerException.class)
    public void testAdd2()throws NullPointerException{
        assertTrue(Elements.add(nullInteger));
    }
    
    @Test (expected=NumberFormatException.class)
    public void testAdd3() throws NumberFormatException {
        String str = null;
        Elements.add(Integer.parseInt(str));
    }
    
    @Test (expected = NullPointerException.class)
    public void testAdd4()throws NullPointerException{  
        nullList.add(new Integer(7));
    }
    
    @Test 
    public void testAdd5(){      
        emptyList.add(new Integer(7));
        assertEquals(1, emptyList.size());
    }
    
    /********** clear Test **********/
    
     @Test
    public void testClear1(){
        Elements.clear();
        assertEquals(0, Elements.size());
    }
    
    @Test
    public void testClear2(){
        Elements.clear();
        assertTrue(Elements.isEmpty());
    }
    
    @Test
    public void testClear3(){
        Elements.clear();
        Elements.add(5);
        assertEquals(1, Elements.size());
    }
    
    @Test (expected = NullPointerException.class)
    public void testClear4() throws NullPointerException{
        nullList.clear();
    }
    
    /********** contains Test **********/
    
    // Listede 1  yok
    @Test
    public void testContains1() {
        assertFalse(emptyList.contains(1));
    }
    
    @Test
    public void testContains2() {
        assertTrue(Elements.contains(21));
    }
    
    @Test
    public void testContains3() {
        assertFalse(Elements.contains(null));
    }
    
    @Test
    public void testContains4() {
        assertFalse(Elements.contains('a'));
    }
    
    @Test
    public void testContains5() {
        assertFalse(Elements.contains(5.2));
    }
    
    @Test (expected = NullPointerException.class)
    public void testContains6() throws NullPointerException{
        assertFalse(nullList.contains(5.2));
    }
    
    /********** iterator Test **********/
/*    
    @Test
    public void testIterator1() {
        int count;
        Iterator<Integer> iter = Elements.iterator();
        Integer testValue = new Integer(0);

        for (count = 0; iter.hasNext(); ++count) {
            testValue = iter.next();
        }

        int expected = Elements.size();
        int result = count;
        assertEquals(expected, result);
    }

    // Next
    @Test
    public void testIterator2() {
        Iterator<Integer> it = Elements.iterator();
        while (it.hasNext())
            assertTrue(it.next() != null);
    }

*/    
    /********** offer Test **********/
    
    @Test
    public void testOffer1() throws IndexOutOfBoundsException {
        Elements.offer(new Integer(2));
        assertEquals(new Integer(2), Elements.peek());
    } 
    
    @Test  (expected = NullPointerException.class)
    public void testOffer2()throws NullPointerException{
        assertTrue(Elements.offer(nullInteger));
    }
    
    @Test (expected=NumberFormatException.class)
    public void testOffer3() throws NumberFormatException {
        String str = null;
        Elements.offer(Integer.parseInt(str));
    }
    
    @Test (expected = NullPointerException.class)
    public void testOffer4()throws NullPointerException{  
        nullList.offer(new Integer(7));
    }
    
    @Test 
    public void testOffer5(){      
        emptyList.offer(new Integer(7));
        assertEquals(1, emptyList.size());
    }
    
    /********** peek Test **********/
    @Test
    public void testPeek1() throws IndexOutOfBoundsException {
        Elements.peek();
        assertEquals(new Integer(4), Elements.peek());
    }
    
    @Test
    public void testPeek2() throws IndexOutOfBoundsException {
        newElements.peek();
        assertEquals(new Integer(51), newElements.peek());
    }
    
    @Test
    public void testPeek3() throws IndexOutOfBoundsException {
        emptyList.peek();
        assertEquals(null, emptyList.peek());
    }
    
    @Test (expected = NullPointerException.class)
    public void testPeek4() throws NullPointerException {
        nullList.peek();
        assertEquals(new Integer(51), Elements.peek());
    }
    
    /********** pool Test **********/
    
    // ilk elemai silip donderme
    @Test
    public void testPoll1() {
        assertEquals(new Integer(4),Elements.poll()); 
    }
    
    // poll succeeds unless empty 
    @Test
    public void testPoll2() {
        int sz = Elements.size();
        for(int j = 0; j < sz; j++) {
            Elements.poll();
        }
        assertNull(Elements.poll());
    }
    
    // ikinci elemani silip donderme
    @Test
    public void testPoll3() {
        Elements.poll();
        assertEquals(new Integer(7),Elements.poll()); 
    }
    
    @Test
    public void testPoll4() {
        Elements.poll();
        assertEquals(new Integer(7),Elements.peek()); 
    }
    
    /********** Remove Test **********/
   
    @Test
    public void testRemove1() {
        Integer first = 7;
        Elements.remove(Elements.peek());
        assertEquals(first, Elements.peek());
    }
    
    @Test
    public void testRemove2() {
        Integer first = Elements.peek();
        Elements.remove(Elements.peek());
        assertNotSame(first, Elements.peek());
    }
    
    @Test
    public void testRemove3() {
        Elements.remove(nullInteger);
    }
    
    @Test
    public void testRemove4() {
        Object num = new String("444");
        assertFalse(Elements.remove(num));
    }
    
    @Test
    public void testRemove5(){
        int size = Elements.size();
        Elements.remove(Elements.peek());
        assertEquals(size-1, Elements.size());
    }
    
    @Test (expected = NullPointerException.class)
    public void testRemove6() throws NullPointerException {
        nullList.remove(nullInteger);
    }
    
    // ilk elemai silip donderme
    @Test
    public void testRemove7() {
        assertEquals(new Integer(4),Elements.remove()); 
    }
    
     // ikinci elemani silip donderme
    @Test
    public void testRemove8() {
        Elements.poll();
        assertEquals(new Integer(7),Elements.remove()); 
    }
    
    
    /********** Size Test **********/
    @Test
    public void testSize1(){
        assertEquals(0,emptyList.size());
    }
    
    @Test
    public void testSize2() {
        assertEquals(8,Elements.size());
    }
    
    @Test
    public void testSize3() {
        assertNotSame(-1,Elements.size());
    }
    
    @Test (expected = NullPointerException.class)
    public void testSize4()throws NullPointerException{
        assertEquals(0,nullList.size());
    }
    
    @Test
    public void testSize5() {
        Integer expResult = 1;
        Integer result = newElements3.size();
        assertEquals(expResult, result);
    }
    
    /********** toArray Test **********/
    
    @Test
    public void testToArray1(){
        Object[] array = Elements.toArray();
        for (Object num : array) {
            assertTrue(null != num);
        }
    }
    
    @Test
    public void testToArray2(){
        Integer[] result = Elements.toArray(new Integer[0]);
        assertEquals(result.length, Elements.size());
    }
    
    @Test
    public void testToArray3(){
        Integer list2[] = new Integer[emptyList.size()];
        list2 = emptyList.toArray(list2);
        for (int number=0; number < list2.length; number++) {
            assertEquals(list2[number], emptyList.poll());
        }        
    }
    
    @Test (expected = NullPointerException.class)
    public void testToArray4()throws NullPointerException{
        Integer list2[] = new Integer[0];
        list2 = (Integer[]) nullList.toArray(list2);
        for (int number=0; number < list2.length; number++) {
            assertEquals(list2[number], nullList.poll());
        }          
    }
    
    @Test (expected = ArrayStoreException.class)
    public void testToArray5() throws ArrayStoreException{
        Object[] result = Elements.toArray(new String[0]);
        result[0] = new Integer(0);
    }
}