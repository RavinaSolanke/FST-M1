package Activities;

import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();
        hs.add("R");
        hs.add("A");
        hs.add("V");
        hs.add("I");
        hs.add("N");
        hs.add("A");
        System.out.println("Original Hashset " +hs);
        System.out.println("Size of Hashset " +hs.size());
        System.out.println("Removing A from Hashset " +hs.remove("A") );
        if (hs.remove("Z")){
            System.out.println("Z removed from the hashset");
        }
        else {
            System.out.println("Z is not present in the hashset");
        }
        System.out.println("Checking if R is present in hashset " +hs.contains("R") );
        System.out.println("Updated Hashset " +hs);
    }
}
