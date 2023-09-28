package algorithms;

import java.util.ArrayList;

public class Recursion {
    public int factorial(int n) {
        if (n > 1) return n * factorial(n - 1);
        else return 1;
    }

    public String reverseString(String text) {
        if (text.length() == 0) return text;
        return reverseString(text.substring(1)) + text.charAt(0);
    }

    public int getTotal(ArrayList<Integer> arr) {
        if (arr.size() > 0) return arr.remove(0) + getTotal(arr);
        else return 0;
    }

}
