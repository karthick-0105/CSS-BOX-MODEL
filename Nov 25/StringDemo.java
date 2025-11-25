package nov25;
import java.util.Scanner;

public class StringDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the strings:");
        String a = scan.nextLine();
        String b = scan.nextLine();

        if (a.equals(b)) {
            System.out.println("True: Both are equal");
        } else {
            System.out.println("False: Both are not equal");
        }

        System.out.println(a.trim());
        System.out.println(b.length());

        if (a.length() > 2) {
            System.out.println(a.charAt(2));
        } else {
            System.out.println("String a is too short for charAt(2)");
        }

        System.out.println(b.replace("karthick", "sundar"));
        System.out.println(a.concat(b));
        System.out.println(a == b ? "True" : "False");

        scan.close();
    }
}
