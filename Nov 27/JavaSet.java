package nov27;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class JavaSet {

	public static void main(String[] args) {
		// 1) HashSet 
		
		HashSet<Integer> set1=new HashSet<Integer>();   
		set1.add(7);  
		set1.add(67);
		set1.add(8);  
		set1.add(7);
		set1.add(5); 
		set1.add(5); 
		
		System.out.println(set1);
		
		// 2) LinkedHashSet 
		LinkedHashSet<String> set2 =new LinkedHashSet<String>();  
		set2.add("Karthi");  
		set2.add("Adib");  
		set2.add("Sakthi");  
		set2.add("Gopi");  
		set2.add("Iqhlas");   
		
		System.out.println(set2);
		
		// 3) TreeSet 
		TreeSet<String> set3 = new TreeSet<String>();
		set3.add("l");
		set3.add("e");
		set3.add("w");
		set3.add("i");
		set3.add("s");
		set3.add("h");
		
		System.out.println(set3); 
	}

}