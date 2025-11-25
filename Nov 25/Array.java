package nov25;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import org.apache.commons.lang3.ArrayUtils;

public class Array {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("enter the size of the array:");
		int a = scan.nextInt();
		scan.nextLine();
		String[] arr = new String[a];

		for (int i = 0; i < a; i++) {
			System.out.println("Enter the index of " + i + ":");
			arr[i] = scan.nextLine();
		}
		// Sorting of array
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));

		// concatenation of array
		int[] arr1 = { 11, 12, 13, 14, 15 };
		int[] arr2 = { 6, 7, 8, 9, 10 };
		int alv[] = ArrayUtils.addAll(arr1, arr2);
		String s = Arrays.toString(alv);
		System.out.println(s);

		// reverse of array
		ArrayUtils.reverse(arr1);
		System.out.println(Arrays.toString(arr1));

		// Convert to ArrayList )
		Integer[] boxedArr = { 1, 2, 3, 7, 8, 9 };
		ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(boxedArr));
		System.out.println(arrayList);

		// checking the array
		String[] stringArray = { "Moni", "Rohith", "Alwyn", "Akash" };
		boolean b = Arrays.asList(stringArray).contains("Moni");
		System.out.println(b);

		int[] intArray = { 1, 2, 3, 5 };
		int[] removed = ArrayUtils.removeElement(intArray, 2);
		System.out.println(Arrays.toString(removed));

	}

}