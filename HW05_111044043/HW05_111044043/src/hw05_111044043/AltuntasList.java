package hw05_111044043;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author Murat ALTUNTAS
 * @param <E>
 */
public class AltuntasList < E > implements List{
    
    private List<ArrayList<E>> myList; // yeni list yapimiz
    private int elemSize = 0;          // listedeki eleman sayisi
    private int nodeSize = 0;          // listedeki nod sayisi
    private final int constSize = 5;   // her bir noddaki arrayin boyutu
    
    /* constructor */
    public AltuntasList() {
        super();
        myList = new LinkedList<ArrayList<E>>();
        myList.add(new ArrayList());
    }
    
    /* Listemizdeki toplam eleman sayisini donduren fonksiyon */
    @Override
    public int size() {
        return elemSize;
    }
    
    @Override
    public Object get(int index) {
        int numNode = index/5;   // Nod sayisi
        int numSize = index%5;   // bulundugu noddaki yeri
        return ((E) myList.get(numNode).get(numSize));
    }

    @Override
    public boolean add(Object e) {        
        if(myList.get(nodeSize).size()<constSize){ // ekelenen elemanin eklendigi node'daki arraylist'in indexi 5 den kucuk ise
            myList.get(nodeSize).add((E) e);       // Node'a elemani ekle.
            elemSize++;                            // eleman sayisini arttir.
        }
        else{                                   // eger eklenecek indeks 5 ise
            nodeSize++;                         // node sayisini arttir
            ArrayList<E> FiveDimension = new ArrayList<E>();  // yeni bir array list olustur.
            myList.add(FiveDimension);          // node'a yeni array listi ekle
            myList.get(nodeSize).add((E) e);    // yeni node'daki arrayliste gelen objeyi ekle
            elemSize++;                         // eleman sayisini arttir.
        }
        
        return true;
    }
    
    @Override
    public void add(int index, Object element) {    
        if (index < 0 || index > elemSize) // index negatifse ve eleman sayisindan buyukse exception firlatir
            throw new IndexOutOfBoundsException("Invalid index " + index);
        
        int tmp = 1; //  elemSizeSize == constSize-1  ise sondan 1 onceki elemandan baslanir.      
        int elemSizeSize = elemSize%constSize; // bulundugu node'daki index
        int tmpNode = nodeSize,    // Node sayisinin yedegi
            tmpNode2 = nodeSize;   // Node sayisinin yedegi
        
        if(index == elemSize){      // indeks eleman sayisine esit ise
            add(element);           // eleman eklenir
        }else if(elemSize == 0){    // eleman sayisi 0 ise yani liste bos ise
            add(element);           // eleman eklenir
        }else{                      // 
            if(elemSizeSize == 0){  // node'da ki arrayList dolu ise 
                nodeSize++;         // node sayisi arttirilir
                ArrayList<E> FiveDimension = new ArrayList<E>(); // Yeni bir arrayList olusturulur
                myList.add(FiveDimension);      //  arrayList node'a eklenir
                myList.get(nodeSize).add(myList.get(nodeSize-1).get(constSize-1)); // node'a önceki Node'un son elemani eklenir
                tmp = 2; // 
            }
        
            for (int i = elemSize-tmp; i >= index; i--) { // eleman sayısından indexe kadar donen dongu
                int iSize = i%constSize;                  // node'daki index
                
                if(iSize == constSize-1){  // 0. index ise
                    // bir onceki node'un arrayListindeki son elemani bir sonraki Node'u arayListinin ilk elemanina yaz
                    myList.get(tmpNode).set(0, myList.get(tmpNode-1).get(iSize)); 
                    tmpNode--;  // yedek node'u bir azalt
                }
                else{  // degilse
                    if(iSize+1 == elemSize) // listenin sonuna ekleniyorsa
                        myList.get(tmpNode).add(myList.get(tmpNode).get(iSize)); // bir sonraki yere eleman eklenir
                    else if(iSize+1 == elemSize%constSize  &&  tmpNode == tmpNode2) // bulundugumuz node'a ekleniyorsa ve node degismemisse
                        myList.get(tmpNode).add(myList.get(tmpNode).get(myList.get(tmpNode).size()-1)); // bulundugumuz node'un array listine, bulundugumuz node'un ArrayListinin size'inin 1 eksigindeki indexinde bulunan eleman eklenir.
                    else
                        myList.get(tmpNode).set(iSize+1, myList.get(tmpNode).get(iSize)); // bir sonraki index'e bir onceki indexteki eleman eklenir (kaydirma)
                }
            }
            int numNode = index/5;   // secilen index kacinci node'da
            int numSize = index%5;   // node'un Array Listinin hangi indexi
            myList.get(numNode).set(numSize, (E) element); // istenen indexe eleman eklenir
            elemSize++; // eleman sayisi arttirilir.
        }
    }
    
    @Override
    public boolean isEmpty() {
            return elemSize == 0;  // eleman sayisi 0 ise true doner
        }

    @Override
    public boolean contains(Object o) {
        if(o == null)       // obje null ise
            return false;   // false return eder
        
        for (int i = 0; i < elemSize; i++) { // eleman sayisi kadar donen dongu
            if(myList.get(i/constSize).get(i%constSize).equals(o)) // eleman listenin icinde var ise true doner
                return true;
        }
        return false;  // yok ise false doner
    }

    @Override
    public Object[] toArray() {
        Object [] lstArr = new Object[elemSize]; // yeni bir obje arrayi alusturulur
        return toArray(lstArr);   // parametreli toArray fonksiyonuna gonderilir
    }

    @Override
    public Object[] toArray(Object[] a) {
        int tmpNd = -1;                       // gecici node sayisi
        
        if(a.length < elemSize)               // obje arrayinin uzunlugu eleman sayisindan az ise
            a = Arrays.copyOf(a, elemSize);   // arrayin size'ini artir
        
        for (int i = 0; i < elemSize; i++) {  // eleman sayisi kadar donen dongu
            if(0 == i%constSize)              // indexin modu 0 ise 
                tmpNd++;                      // node sayisini arttir
            a[i] = myList.get(tmpNd).get(i%constSize); // arraye elemani ekle
        }
        return a; // arrayi return et
    }

    @Override
    public boolean remove(Object o) { 
        int tmp = -1;                        // gecici node sayisi
        for (int i = 0; i < elemSize; i++) { // eleman sayisi kadar donen dongu
            if(0 == i%constSize)             // indexin modu 0 ise 
                tmp++;                       // node sayisi arttirilir
            if(myList.get(tmp).get(i%constSize) ==  o) { // obje listede var ise
                remove(i);    // objenin indexinin remove'un indexli fonksiyouna gonder
                return true;  // true return et
            }                
        }
        return false; // listede yoksa false return et
    }

    @Override
    public boolean containsAll(Collection c) {
        if(c == null)                          // gelen parametre null ise
            throw new NullPointerException();  // exception firlat
        if (c.isEmpty())                       // gelen liste bos ise 
            return true;                       // true return et
        
        int returnVal = 0;                     // Collection'daki elemanlarin arrayde var olanlarinin sayisi
        for (int i = 0; i < c.size(); i++) {   // Collectio'in size'i kdr donen dongu
            for (int j = 0; j < elemSize ; j++) {       // eleman size'i kdr donen dongu
                if(((List<E>)c).get(i).equals(get(j))){ // Collection'da ki elemanlar array de var mi diye kontrol edilir
                    returnVal++;               //  var ise degisken arttirilir
                    break;                     // içteki donguden cikilir
                }
            }
        }
        return returnVal == c.size();          // donguler bitnce degiskenin sayisi ile Collection'in size lari birbirine esitse true return edilir
    }

    @Override
    public boolean addAll(Collection c) {
        if(c == null)                        // Collection null ise
            throw new NullPointerException();// exception firlatilir
        if(c.isEmpty())                      // Collection bos ise
            return false;                    // false doner
        
        for (int i = 0; i < c.size(); i++) { // Collection'in size'i kadar donen dongu
            add(((List<E>)c).get(i));        // Collection'daki elemanlari teker teker array'e ekler
        }
        return true;                         
    }

    @Override
    public boolean addAll(int index, Collection c) {
        if(c == null)                        // Collection null ise
            throw new NullPointerException();// exception firlatilir
        if(c.isEmpty())                      // Collection bos ise
            return false;                    // false doner
        
        for (int i = 0; i < c.size(); i++) { // Collection'in size'i kadar donen dongu
            add(index+i, ((List<E>)c).get(i));// Collection'daki elemanlari istenen indexten itibaren array'e ekler
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection c) {
        if(c.isEmpty())   // Collection bos ise 
            return false; // false return eder
        if(c == null)     // Collection null ise 
            throw new NullPointerException(); // exception firlatir
        boolean result = false;               // sonuc degiskeni
        for (int i = 0; i < c.size(); i++) {  // Collection'in size'i kadar donen dongu
            if(remove(((List<E>)c).get(i)))   // remove fonksiyonundan o indexte gigidlir ve silinirse
                result = true;                // true return edilir.
        }
        return result;
    }

    @Override
    public boolean retainAll(Collection c) {
        if(c == null)                        // gelen Collection objesi null ise 
            throw new NullPointerException();// exception firlatir
        if (c.isEmpty()){                    // gelen obje bos ise 
            clear();                         // liste temizlenir
            return true;                     // true return edilir
        }        
        int tmpElemSize = elemSize;          // eleman sayisinin yedegi
        int delete=0;                        // silinecek index
        boolean choosen = false,             // kontrol icin
                returnVal = false;           // return icin
        for (int i = 0; i < tmpElemSize; i++) {  // Eleman sayisi kadar donen dongu
            for (int j = 0; j < c.size(); j++) { // Collection objesinin boyutu kadar donen dongu
                if(((List<E>)c).get(j).equals(get(delete))){ // Collection objesinin bir elemani arrayin icinde var ise
                    choosen = true;    // kontrol degiskeni true yapilir
                    returnVal = true;  // return degeri true yapilir
                    delete++;          // delete degeri 1 arttirilir
                    break;             // break ile ic donguden cikilir
                }
            }
            if(false == choosen)      // kontrol degiskeni true ise 
                remove(delete);       // secili indexteki elemani sil
            choosen=false;            // kontrol degiskenini false yap
        }
        return returnVal;             // return degerini dondur
    }

    @Override
    public void clear() {
        myList = new LinkedList<ArrayList<E>>(); // var olan listeye yeniden bir yer al.
        myList.add(new ArrayList());             // ilk noda arraylist ekle
        elemSize = 0;  // eleman sayısını sıfırla
        nodeSize = 0;  // node sayısını sıfırla
    }   

    @Override
    public Object set(int index, Object element) {
        // istenen indexteki elemani yeni eleman ile degistir
       return myList.get(index/constSize).set(index%constSize, (E)element);
    }

    @Override
    public Object remove(int index) {
        if (index < 0 || index >= elemSize) // index negatif ve eleman sayisina esit yada buyukse 
            throw new IndexOutOfBoundsException("Invalid index " + index); // exception firlat
        
        int tmpNode = nodeSize; // node sayisinin yedegi
        int numNode = index/5;  // elemanin bulundugu nod
        int numSize = index%5;  // elemanin o nodda bulundugu index
        int iSize=0;            // index icin
        E returnVal = myList.get(numNode).get(numSize); // silinecek eleman
        
        if((myList.get(tmpNode).size() == 1) && (index == elemSize-1) ){ // node'da ki tek elemansa ve silinecek eleman son elemansa
            myList.remove(tmpNode);    // node'u sil
            nodeSize--;                // node sayisini bir azalt
            elemSize--;                // eleman sayisini bir azalt
        }else if(index != elemSize-1){ // son eleman disinda bir elemansa
            for (int i = index; i < elemSize-1; i++) { // indexten son elemana kadar donen dongu
                iSize = i%constSize;  // secili indexin o node daki yeri
                
                if(iSize == constSize-1){ // secilen index o node'un son elemani ise
                    myList.get(numNode).set(constSize-1, myList.get(numNode+1).get(0)); // bir sonraki node'da ki ilk elemani bulundugu node'un son elemanina ekle
                    numNode++; // bir sonraki node'a gec
                }
                else{ // secilen index o node'un son elemani degilse
                    myList.get(numNode).set(iSize, myList.get(numNode).get(iSize+1)); // node'da ki bir sonraki elemani secilen indexin yerine yaz
                }
            }
            myList.get(numNode).remove((elemSize-1)%constSize); // son elemai sil
            elemSize--; // eleman sayisini bir azalt
            
            
            if(myList.get(numNode).size() == 0){ // node'un arraylistinin size'i 0 ise
                myList.remove(tmpNode); // node'u sil
                nodeSize--;             // node sayisini bir azalt
            }
            
        }else if(index == elemSize-1){ // secilen index son elemansa
            myList.get(numNode).remove((elemSize-1)%constSize); // son elemani sil
            elemSize--; // eleman sayisini bir azalt
        }
        return returnVal;  // silinen elemani dondur
    }

    @Override
    public int indexOf(Object o) {
        int tmp = -1; // node indexi
        for (int i = 0; i < elemSize; i++) { // eleman sayisi kadar donen dongu
            if(0 == i%constSize)    // index 5 in kati ise
                tmp++;              // bir sonraki node'a gec
            if(myList.get(tmp).get(i%constSize) ==  o) { // obje listede var ise
                return i; // indexini return et
            }                
        }
        return -1;  // yoksa -1 return et
    }

    @Override
    public int lastIndexOf(Object o) {        
        if(elemSize == 0 || o == null) // eleman sayisi 0 sa yada obje nulll ise
            return -1;                 // -1 dondur
        else                           // degilse
            return indexOf(o);         // objeyi indexOf a gonder, ordan gelen degeri dondur
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
         // ilk index negatifse yada son index eleman sayisindan buyukse yada ilk index son indexten buyukse
        if (fromIndex < 0 || toIndex > elemSize || fromIndex > toIndex)
            throw new IndexOutOfBoundsException("Invalid index " + fromIndex + " " + toIndex); // exception firlat
        if(fromIndex==0 && toIndex==size()) // ilk index 0 ve son index eleman sayisina esit ise
            return this;                    // listenin kendisini dondur
        AltuntasList<E> newList = new AltuntasList<E>(); // yeni bir liste olustur
        for (int i = 0; i < elemSize; i++) { // eleman sayisi kadar donen dongu
           // ilk indexten son indexe kadar olan elemanlari yeni listeye ekle
            if(i>=fromIndex && toIndex > i)  
                newList.add((E) get(i));
        }
        return newList; // yeni listeyi dondur
    }
    
    @Override
    public boolean equals(Object o){
        return (this == o); // objeler ayni ise true degilse false doner
    }    
    
    @Override
    public int hashCode(){
        int hashCode = 1;
        E e;
        for (int i = 0; i < elemSize; i++) { // eleman sayisi kadar donen dongu
            e = (E) get(i);
            hashCode = 31*hashCode + (e==null ? 0 : e.hashCode()); // hashCode hesabi
        }
        return hashCode;
    }
        
    @Override
    public Iterator iterator() {
        return AltuntasIter();
    }
    
    @Override
    public ListIterator listIterator() {
        return AltuntasListIter(0);
    }

    @Override
    public ListIterator listIterator(int index) {
        return AltuntasListIter(index);
    }

    public ListIterator<E> AltuntasListIter(int index){
        List<E> lst = new LinkedList<E>(); // Yeni bir liste olustuulur
        
        for (int i = 0; i < elemSize; i++) { // eleman sayisi kadar donen dongu
            lst.add((E) get(i));             // yeni listeye kendi listemizdeki elemanlar eklenir
        }
        return lst.listIterator(index);      // list in iteratorune gonderilir. donen deger return edilir
    }
    
    public Iterator<E> AltuntasIter(){
        List<E> lst = new LinkedList<E>(); // Yeni bir liste olustuulur
        
        for (int i = 0; i < elemSize; i++) { // eleman sayisi kadar donen dongu
            lst.add((E) get(i)); // yeni listeye kendi listemizdeki elemanlar eklenir
        }
        return lst.iterator(); // list iteratorunden. donen deger return edilir
    }
} /* End of the AltuntasList Class */
