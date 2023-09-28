package easy;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class RemoveLetter {
    public boolean equalFrequency(String word) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (char i: word.toCharArray()) {
           if(map.containsKey(i)) map.put(i, map.get(i)+1);
           else map.put(i, 1);
        }

        int base = map.get(word.charAt(0));
        System.out.println(map.values().stream().sorted());
        for (Integer value : map.values()) {
            System.out.println(value);
        }


        System.out.println(map +" "+ base);
        return true;
    }
}
