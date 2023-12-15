package Activities;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("Banana");
        myList.add("Apple");
        myList.add("Mango");
        myList.add(1, "Papaya");
        myList.add(3, "Grapes");

        System.out.println("Print all the names");
        for (String s:myList){
            System.out.println(s);
        }
        System.out.println("Third element in the list is " +myList.get(2));
        System.out.println("Is Lemon is in the list is "  +myList.contains("Lemon"));
        System.out.println("Size of the Arraylist " +myList.size());
        myList.remove("Papaya");
        System.out.println("Size fo the Arraylist " +myList.size());
    }
}
