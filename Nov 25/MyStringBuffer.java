package nov25;

public class MyStringBuffer {

    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer("Hello ");
        sb.append("FullStack");
        System.out.println(sb);

        StringBuffer s = new StringBuffer("Vamsi");
        System.out.println(s);

        // insert example
        sb.insert(5, "_");
        System.out.println(sb);

        // replace example
        sb.replace(6, 10, "World");
        System.out.println(sb);

        // delete example
        sb.delete(5, 6);
        System.out.println(sb);

        // reverse example
        System.out.println(sb.reverse());
    }
}
