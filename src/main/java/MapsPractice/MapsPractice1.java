package MapsPractice;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapsPractice1 {
    public static void main(String args[])
    {
        // Creating an empty HashMap
        Map<String, Integer> hm = new HashMap<String, Integer>();
        System.out.println("Map Is Empty? " + hm.isEmpty());
        // Inserting pairs in above Map
        // using put() method
        hm.put("a", 100);
        hm.put("b", 200);
        hm.put("c", 300);
        hm.put("d", 400);
        hm.put("e", 500);
        hm.put("f", null);

        System.out.println("Added Values:" + hm.values());
        System.out.println("Map Is Empty? " + hm.isEmpty());
        System.out.println("Display Map Method ---");
        displayMap(hm);
        System.out.println("---");
        System.out.println("Contains key \"a\"? " + hm.containsKey("a")); //true
        System.out.println("Contains key \"g\"? " + hm.containsKey("f")); //false
        System.out.println("Contains value \"700\"? " + hm.containsValue(700)); //false
        System.out.println("Contains key \"500\"? " + hm.containsValue(500)); //true
        System.out.println("Map Size: " + hm.size());
        hm.putIfAbsent("f", 600);
        System.out.println("\"f\" key associated with value: 600");
        displayMap(hm);
        hm.remove("f");
        System.out.println("Removed key: \"f\"");
        displayMap(hm);




        Map<String, Integer> newMap = new HashMap<String, Integer>();








//        Map<String, Integer> map = new TreeMap<>();
//
//        // Inserting custom elements in the Map
//        // using put() method
//        map.put("vishal", 10);
//        map.put("sachin", 30);
//        map.put("vaibhav", 20);
//
//        // Iterating over Map using for each loop
//        for (Map.Entry<String, Integer> e : map.entrySet()) {
//
//            // Printing key-value pairs
//            System.out.println(e.getKey() + " "
//                    + e.getValue());
//    }




////         Traversing through Map using for-each loop

    }

    public static void displayMap(Map<String, Integer> hm) {
        for (Map.Entry<String, Integer> me : hm.entrySet()) {
            // Printing keys
            System.out.print(me.getKey() + ":");
            System.out.println(me.getValue());
        }
    }
}
