package nov27;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class CollectionsJava {

	public static void main(String[] args) {

		// ArrayList

		ArrayList<String> list = new ArrayList<String>();
		list.add("Karthick");
		list.add("Sakthi");
		list.add("AGI");
		System.out.println("ArrayList : ");
		System.out.println(list);

		Iterator it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		System.out.println("---------------------");

		// LinkedList

		LinkedList<String> ll = new LinkedList<String>();
		ll.add("Adib");
		ll.add("Gopi");
		ll.add("KSI");
		System.out.println("LinkedList : ");
		System.out.println(ll);

		Iterator<String> itr = ll.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("---------------------");
		
		// Speed test between these 2 ...

		long StartTime = System.currentTimeMillis();
		ArrayList<String> test1 = new ArrayList<String> ();
		for (int i = 0; i < 100000; i++) {
			test1.add("TEST_1");
			test1.add("TEST_2");
			test1.add("TEST_3");
		}
		System.out.println("Time taken by ArrayList: " + (System.currentTimeMillis() - StartTime) + "ms");
		
		StartTime = System.currentTimeMillis();
		LinkedList<String> test2 = new LinkedList<String>();
		for (int i = 0; i < 100000; i++) {
			test2.add("TEST_1");
			test2.add("TEST_2");
			test2.add("TEST_3");
		}
		System.out.println("Time taken by LinkedList: " + (System.currentTimeMillis() - StartTime) + "ms");
		System.out.println();
		

	}

}