package nov27;

import java.util.HashMap;
import java.util.Map;

public class MapJava {

	public static void main(String[] args) {
		HashMap<Integer,String> map1=new HashMap<Integer,String>(); 
		   map1.put(1,"Ducati");  
		   map1.put(2,"KTM");    
		   map1.put(3,"Kawasaki");   
		   map1.put(1,"Aprilia");   
		       
		   System.out.println("Iterating Hashmap..."); 
		   for(Map.Entry m : map1.entrySet()){    
			    System.out.println(m.getKey()+" "+m.getValue());    
			   } 		   
		   
		 HashMap<Integer,String> hm=new HashMap<Integer,String>();    
		    System.out.println("Initial list of elements: "+hm);  
		      hm.put(100,"Lambo");    
		      hm.put(101,"Porsche");    
		      hm.put(102,"Ferrari");   
		       
		      System.out.println("After invoking put() method ");  
		      for(Map.Entry m:hm.entrySet()){    
		       System.out.println(m.getKey()+" "+m.getValue());    
		      }  
		        
		      hm.putIfAbsent(103, "Bugatti");  
		      System.out.println("After invoking putIfAbsent() method ");  
		      for(Map.Entry m:hm.entrySet()){    
		           System.out.println(m.getKey()+" "+m.getValue());    
		          }  
		      HashMap<Integer,String> map=new HashMap<Integer,String>();  
		      map.put(104,"Pagani");  
		      map.putAll(hm);  
		      System.out.println("After invoking putAll() method ");  
		      for(Map.Entry m:map.entrySet()){    
		           System.out.println(m.getKey()+" "+m.getValue());    
		          }  

	}

}