package common;

import easy.*;

public class MainHelper {
    public static void runEasy(){
        LongestPrefix lp = new LongestPrefix();
        System.out.println(lp.longestCommonPrefix(new String[] { "flower","mflow","nflight","ofl"})); //"flower","flow","flight","flo"

         /*
        MergeStringAlternately msa = new MergeStringAlternately();
        System.out.println(msa.mergeAlternately("ab", "pqrs"));

        PalindromeNumber pn = new PalindromeNumber();
        System.out.println(pn.isPalindrome(121));

        TwoSum ts = new TwoSum();
        int [] arr = ts.twoSum(new int[]{-3,4,3,90}, 0);
        for (int integer : arr) {
            System.out.println(integer);
        }
        RomanToInt rti = new RomanToInt();
        System.out.println(rti.romanToInt("MCMXCIV"));
        */
    }
}
