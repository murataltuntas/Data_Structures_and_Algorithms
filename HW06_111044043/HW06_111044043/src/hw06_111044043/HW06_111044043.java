package hw06_111044043;
/**
 *
 * @author Murat ALTUNTAS
 * @number 111044043
 * @mail   murataltuntas44@gmail.com
 */
public class HW06_111044043 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {    
        MyPriorityQueue<Integer> elems = new MyPriorityQueue();
        elems.add(11);
        elems.add(21);
        elems.offer(13);
        elems.offer(15);
        elems.add(18);
        elems.add(7);
        elems.offer(4);
        elems.offer(16);
        System.out.println(elems.toString());
        Object[] arr = new Integer[elems.size()];

        System.out.println("poll:   " + elems.poll()); // peekin aynısı ama en tepedekini siler
        System.out.println("peek:   " + elems.peek());        
        System.out.println("remove(): " + elems.remove()); // poll un aynısı
        System.out.println("peek:   " + elems.peek());        
        System.out.println("remove(7): " + elems.remove(7)); // poll un aynısı
        System.out.println("peek:   " + elems.peek());
        System.out.println("contains(16): " +  elems.contains(16));
        System.out.println(elems.toString());
        System.out.println("toArray():   ");
        arr = elems.toArray();
        
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + " : " + arr[i]);
        }
        System.out.println("size: " + elems.size());
        System.out.println("remove(15): " + elems.remove(15));
        System.out.println("poll:   " + elems.poll());
        System.out.println("peek:   " + elems.peek());
        System.out.println("clear: ");
        elems.clear();
        System.out.println("size: " + elems.size());
        elems.offer(15);
        elems.add(18);
        elems.add(7);
        elems.offer(4);
        System.out.println("elemenlar eklendikten sonra size: " + elems.size());
        
        System.out.println("toArray(array):   ");
        Object[] array = new Integer[elems.size()];
        arr = elems.toArray(array);
        
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + " : " + arr[i]);
        }
        
        System.out.println("contains(21): " +  elems.contains(21));
    }
}
