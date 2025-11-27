package nov27;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyArrayList {

    public static void main(String[] args) {

        String[] values = {"K", "G", "A", "S", "Hey", "oldie", "55", "#", "G", "$"};

        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();

        for (String va : values) {
            arrayList.add(va);
            linkedList.add(va);
        }

        System.out.println("ArrayList Values: " + arrayList);
        System.out.println("LinkedList Values: " + linkedList);
    }
}