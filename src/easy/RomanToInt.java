package easy;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.*;

public class RomanToInt {

    Map<String, Integer> map = new HashMap<>();
    List<String> exceptionalNum = Arrays.asList("IV", "IX", "XL", "XC", "CD", "CM");


    void validRomanPut() {
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
    }

    int getTheNum(char main, char aux) {
        if (exceptionalNum.contains("" + main + aux) && aux >= 65 && aux <= 90) return map.get("" + main + aux);
        else return map.get("" + main);
    }


    public int romanToInt(String s) {
        validRomanPut();
        int result = 0;
        List<Integer> exceptionalNum = Arrays.asList(4, 9, 40, 90, 400, 900);
        CharacterIterator it = new StringCharacterIterator(s);
        while (it.current() != CharacterIterator.DONE) {
            int num = getTheNum(it.current(), it.next());
            result += num;
            if (exceptionalNum.contains(num)) it.next();

        }
        return result;
    }
}