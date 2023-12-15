package Activities;

import java.util.HashMap;

public class Activity11 {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
        hashMap.put(1, "Red");
        hashMap.put(2, "Green");
        hashMap.put(3, "Blue");
        hashMap.put(4,"White");
        hashMap.put(5, "Black");
        System.out.println("The Original map " +hashMap);
       hashMap.remove(4);
        System.out.println("After removing White " +hashMap);
        if (hashMap.containsValue("Green")){
            System.out.println("Green exist in the map");
        }
        else{
            System.out.println("Green does not exist in the map");
        }
        System.out.println("Number of pairs in the map is " +hashMap.size());
    }
}
