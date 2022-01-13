package exercise;

import java.util.Set;
import java.util.TreeMap;

public class CountWord {
    public static void main(String[] args) {
        String str = "A A A A B B B B C";
        TreeMap<String, Integer> map = new TreeMap<>();
        for (String element : str.split(" ")) {
            map.put(element, map.get(element) == null ? 1 : (map.get(element)) + 1);
        }
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println(key + " - " + map.get(key));
        }
    }
}
