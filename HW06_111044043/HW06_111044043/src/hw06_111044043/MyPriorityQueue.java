package hw06_111044043;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Murat ALTUNTAS
 * @number 111044043
 * @mail   murataltuntas44@gmail.com
 */
public class MyPriorityQueue<E> implements Serializable, Comparator<E> { 
    // Data Field
    /** The root of the PriorityQueue tree */
    protected Node < E > root;
   /** An optional reference to a Comparator object. */
   Comparator < E > comparator = new Comparator<E>() {
        public int compare(E left, E right) {
            if (comparator != null) { // A Comparator is defined.
              return comparator.compare(left, right);
            }
            else { // Use left’s compareTo method.
              return ( (Comparable < E > ) left).compareTo(right);
            }
        }
    };
    /** node size */
    private int sizeCount=0;  
    private boolean returnValue ;  /* boolean returnValue */
       
    public MyPriorityQueue() {
      root = null;
      comparator = null;
    }

    protected MyPriorityQueue(Node < E > root) {
      this.root = root;
    }

    /** Constructs a new MyPriorityQueue with data in its root,leftTree
        as its left subtree and rightTree as its right subtree.
     */
    public MyPriorityQueue(E data, MyPriorityQueue < E > leftTree,
                                   MyPriorityQueue < E > rightTree) {
      root = new Node < E > (data);
      if (leftTree != null) {
        root.left = leftTree.root;
      }
      else {
        root.left = null;
      }
      
      if (rightTree != null) {
        root.right = rightTree.root;
      }
      else {
        root.right = null;
      }
    }

    /* add method */
    public boolean add(E element){
        return offer(element);       
    }
    
    public void clear(){
        this.root = null;
        sizeCount = 0;
    }
    
    public boolean contains(Object obj){
        Object[] arr = this.toArray();         
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == obj){
                return true;
            }
        }
        return false;
    }
    
    public Iterator<E> iterator(){
        return null;    
    }
    
    public boolean offer(E item) {
        if(root == null){
            root = new Node(item);
            sizeCount++;
            return true;
        }
        else
            root = offer(root, item); 
        sizeCount++;
        return returnValue;
    }
    
   private Node<E> offer (Node < E > localRoot, E item ){
        if (localRoot == null) {
          // item is not in the tree — insert it.
          returnValue = true;
          return new Node < E > (item);
        }
        else if ( localRoot.left==null )
        {
            returnValue = true ;
            localRoot.left = offer(localRoot.left,item);
                     edit(root);

            return localRoot;
        }
        else if ( localRoot.right==null)
        {
            returnValue = true ;
            localRoot.right = offer(localRoot.right,item);
                     edit(root);

            return localRoot ;
        }
        else if ( compare(item,localRoot.right.data)<0 )
        {
            returnValue = true ;            
            localRoot.left = offer(localRoot.left,item);
                     edit(root);

            return localRoot;
        }
        else 
        {
            returnValue = true ;            
            localRoot.right = offer(localRoot.right,item);
                     edit(root);

            return localRoot;            
        }
    }
   
   /*
        recursive edit fonksiyonu
        offer fonksiyonunda root gonderilerek
        heap olma kosulu yani en kucugu en ustte tutma saglanir
    */
    private boolean edit ( Node<E> localRoot ){
        if ( localRoot == null)
        {
            return false;
        }
        else if ( localRoot.left!=null && compare(localRoot.data,localRoot.left.data) > 0) 
        {
            Node<E> temp = new Node<E>(localRoot.data);
            localRoot.data=localRoot.left.data;
            localRoot.left.data=temp.data;
            edit(localRoot.left);
            return true ;
        }
        else if ( localRoot.right!=null && compare(localRoot.data,localRoot.right.data) > 0) 
        {
            Node<E> temp = new Node<E>(localRoot.data);
            localRoot.data=localRoot.right.data;
            localRoot.right.data=temp.data;
            edit(localRoot.right);
            return true ;
        }
        else 
        {
            edit(localRoot.right);
            edit(localRoot.left);
            return true ;
        }
    }
    
    /*
        peek fonksiyonu en kucuk elemani
        silmeden return eder
        dizi bossa null return eder
    */
    public E peek() {
        if ( root == null)
            return null ;
        else
        return root.data ;   
    }
    
    public E poll() {
        if(root==null)
            return null;
        else
        {       
            E rtrn = root.data;            
            root = poll(root.left, root.right);
            sizeCount--;          
            return rtrn;
        }
    }
    
    private Node<E> poll(Node<E> leftNode, Node<E> rightNode) 
    {
        if (leftNode ==null  &&  rightNode == null) { return null; }
        if (leftNode == null)      { return rightNode; }
        if (rightNode == null)     { return leftNode; }            
        
        if (compare(leftNode.data,rightNode.data)<0) 
        {
            Node<E> temp = leftNode.left;
            leftNode.left = poll(leftNode.right, rightNode);
            leftNode.right = temp;
            return leftNode;
        }
        else 
        {
            Node<E> temp = rightNode.right;
            rightNode.right = poll(rightNode.left, leftNode);
            rightNode.left = temp;
            return rightNode;
        }
    }
       
    /**
     * Removes the smallest entry and returns it if the queue is empty
     * @return the smallest entry
     * @throws NoSuchElementException if queue is empty;
     */
    public E remove() {
        E temp = poll();

        if (temp == null) {
            throw new NoSuchElementException("The Three is Empty!!!");
        } else {
            return temp;
        }
    }
    
    public boolean remove(Object obj){
        E[] arr = (E[]) new Object[sizeCount];
        E[] arr2 = (E[]) new Object[sizeCount];
        arr = this.toArray(arr);
        int sz = sizeCount;
        boolean retVal = false;
        int j = 0;
        for (int i = 0; i < sz; i++) {
            if(!(arr[i].equals(obj))){
                arr2[j] = arr[i];                
                j++;
            }else{
                sizeCount--;
                retVal = true;
            }
        }
        this.clear();
        for(int k = 0; k < j; k++) {
            this.offer((E)arr2[k]);
        }
        return retVal;
    }
   
    public int size(){
        return sizeCount;        
    }
    
    public Object[] toArray(){
        int sz = this.size();
        Object[] arr = new Object[sz];
        for(int i = 0; i < sz; i++) {
            arr[i] = this.poll();
        }
        for(int j = 0; j < sz; j++) {
            this.offer((E)arr[j]);
        }
        return arr;
    }
    
    public <T> T[] toArray(T[] arr){
        int sz = this.size();
        if(arr.length < sz)               // obje arrayinin uzunlugu eleman sayisindan az ise
            arr = Arrays.copyOf(arr, sz); // arrayin size'ini artir
        for (int i = 0; i < sz; i++) {  // eleman sayisi kadar donen dongu            
            arr[i] = (T) this.poll();
        }
        for(int j = 0; j < sz; j++) {
            this.offer((E)arr[j]);
        }
        return arr;
    }
    
    public boolean isEmpty(){
        return (root==null);        
    }
    
    /*
        elements fonksiyonu
        en kucuk elemani return eder
        bossa exception firlatir
    */
    public E elements() throws NoSuchElementException {
        try
        {
            if ( root==null )
                throw new NoSuchElementException() ;            
        }
        catch ( NoSuchElementException e)
        {
            System.out.println("Exception : NoSuchElement .");
        }
       return this.root.data;
    }
    
    /** Compare two items using either a Comparator object’s compare method
       or their natural ordering using method compareTo.
       pre: If comparator is null, left and right implement Comparable<E>.
       @param left One item
       @param right The other item
       @return Negative int if left less than right,
          0 if left equals right,
          positive int if left > right
       @throws ClassCastException if items are not Comparable
   */           
 
  @Override
  public int compare(E left, E right) {
    if (comparator != null) { // A Comparator is defined.
      return comparator.compare(left, right);
    }
    else { // Use left’s compareTo method.
      return ( (Comparable < E > ) left).compareTo(right);
    }
  }
  
   /** Class to encapsulate a tree node. */
  protected static class Node < E > implements Serializable {
    // Data Fields
    /** The information stored in this node. */
    protected E data;

    /** Reference to the left child. */
    protected Node < E > left;

    /** Reference to the right child. */
    protected Node < E > right;

    // Constructors
    /** Construct a node with given data and no children.
        @param data The data to store in this node
     */
    public Node(E data) {
      this.data = data;
      left = null;
      right = null;
    }

    // Methods
    /** Return a string representation of the node.
        @return A string representation of the data fields
     */
    public String toString() {
      return data.toString();
    }
  }
  
    public String toString() {
      StringBuilder sb = new StringBuilder();
      preOrderTraverse(root, 1, sb);
      return sb.toString();
    }

    /** Perform a preorder traversal.
        @param node The local root
        @param depth The depth
        @param sb The string buffer to save the output
     */
    private void preOrderTraverse(Node < E > node, int depth, StringBuilder sb){
      for (int i = 1; i < depth; i++) {
        sb.append("  ");
      }
      if (node == null) {
        sb.append("null\n");
      }
      else {
        sb.append(node.toString());
        sb.append("\n");
        preOrderTraverse(node.left, depth + 1, sb);
        preOrderTraverse(node.right, depth + 1, sb);
      }
    }
}