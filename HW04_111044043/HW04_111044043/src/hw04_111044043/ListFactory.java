/*
 * Murat ALTUNTAS
 * 111044043
 */

package hw04_111044043;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Murat
 */
public class ListFactory {    	
   //use getList method to get object of type list 
   public List getList(String listType){
      if(listType == null){
         return null;
      }		
      if(listType.equalsIgnoreCase("Array")){
         return new ArrayList();
     
      } else if(listType.equalsIgnoreCase("Linked")){
         return new LinkedList();
      }
      
      return null;
   }
}
