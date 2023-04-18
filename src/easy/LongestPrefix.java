package easy;

import java.util.Arrays;
import java.util.Comparator;

public class LongestPrefix {

    String getTheLongestPrefix(String[] arr, int prefixIndex, String smallestWord, String prefix) {
        if (arr.length != Arrays.stream(arr)
                        .filter(s -> s.startsWith(prefix))
                        .map(s -> s.substring(s.indexOf(prefix)))
                        .count())
            return prefix.substring(0, prefixIndex - 1);

        else return getTheLongestPrefix(arr, ++prefixIndex,
                    smallestWord, smallestWord.substring(0, prefixIndex));
    }

    public String longestCommonPrefix(String[] strs) {
        return getTheLongestPrefix(strs, 1, "" + Arrays.asList(strs).stream()
                .min(Comparator.comparingInt(String::length)).get(), "");
    }

}
