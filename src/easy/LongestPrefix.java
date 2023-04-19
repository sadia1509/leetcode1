package easy;

import java.util.Arrays;
import java.util.Comparator;

public class LongestPrefix {

    String getTheLongestPrefix(String[] arr, int prefixIndex, String smallestWord, String prefix) {
        //System.out.println(arr.length+ " "+ Arrays.stream(arr).filter(s -> s.startsWith(prefix)).map(s -> s.substring(s.indexOf(prefix))).count() );
        if (arr.length != Arrays.stream(arr)
                        .filter(s -> s.startsWith(prefix))
                        .map(s -> s.substring(s.indexOf(prefix)))
                        .count())
            return prefix.substring(0, prefixIndex - 1);
        else if (smallestWord.length() > prefixIndex) return getTheLongestPrefix(arr, ++prefixIndex,
                    smallestWord, smallestWord.substring(0, prefixIndex));
        else return prefix;
    }

    public String longestCommonPrefix(String[] strs) {
        String smallestWord = Arrays.asList(strs).stream().min(Comparator.comparingInt(String::length)).get();
        if (smallestWord.length()>0) return getTheLongestPrefix(strs, 1, smallestWord , ""+smallestWord.charAt(0));
        else return "";
    }

}
