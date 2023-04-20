package common;

import easy.*;


public class MainHelper {

    static ListNode buildLinkedList(int[] a) {
        if (a.length < 1) return new ListNode();
        ListNode head = new ListNode(a[0]);
        ListNode tail = head;
        for (int i = 1; i < a.length; i++) {
            ListNode node = new ListNode(a[i]);
            tail.next = node;
            tail = node;

        }
        return head;
    }

    public static void runEasy() {

        MajorityElement majorityElement= new MajorityElement();
        System.out.println(majorityElement.majorityElement(new int[]{3,2,3}));
        /*
        SingleNumber singleNumber= new SingleNumber();
        System.out.println(singleNumber.singleNumber(new int[]{1,1,2,2,3,4,4}));

        PalindromeNumber palindromeNumber2 = new PalindromeNumber();
        System.out.println(palindromeNumber2.isPalindrome("zzoozz"));

        StockSellBuy stockSellBuy = new StockSellBuy();
        System.out.println("result--> "+stockSellBuy.maxProfit(new int[]{7,1,5,3,6,4}));

        PascalTriangle pascalTriangle = new PascalTriangle();
        //System.out.println(pascalTriangle.generate(3));
        System.out.println(pascalTriangle.getRow(3));

        RemoveDuplicates remove = new RemoveDuplicates();
        remove.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2);

        MergeTwoSortedList mergeTwoSortedList2 = new MergeTwoSortedList();
        mergeTwoSortedList2.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);

        DeleteDuplicateFromList deleteDuplicateFromList = new DeleteDuplicateFromList();
        ListNode head = deleteDuplicateFromList.deleteDuplicates(buildLinkedList(new int[]{}));
        for (ListNode n = head; n != null; n = n.next) System.out.println(n.val);

        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(6));

        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
                "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));

        PlusOne plusOne = new PlusOne();
        int[] result = plusOne.plusOne(new int[]{7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 6}); //9,8,7,6,5
        for (int i : result) System.out.print(i + "");

        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        System.out.println(lengthOfLastWord.lengthOfLastWord("   fly me   to   the moon  "));


        Finding finding = new Finding();
        // System.out.println(finding.strStr("sadbutsad", "sadu"));
        System.out.println(finding.searchInsert(new int[]{1, 3, 5, 6}, -6));
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        //  System.out.println(removeDuplicates.removeDuplicates(new int[]{0,1,1,1,1,1,1,1,1,1,2,3,3,3,4,6,6,6,6,7,7,7,10}));
        System.out.println(removeDuplicates.removeElement(new int[]{3, 2, 2, 3}, 3));

        MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();
        ListNode head = mergeTwoSortedList
                .mergeTwoLists(buildLinkedList(new int[]{2, 3}), buildLinkedList(new int[]{1}));
        for (ListNode l = head; l != null; l = l.next) System.out.println("--> " + l.val);
        System.out.println(buildLinkedList(new int[]{}).val);

        ValidParenthesis validParenthesis = new ValidParenthesis();
        System.out.println(validParenthesis.isValid("()["));

        LongestPrefix longestPrefix = new LongestPrefix();
        System.out.println(longestPrefix.longestCommonPrefix(new String[]{"", ""})); //"flower","flow","flight","flo"

        MergeStringAlternately mergeStringAlternately = new MergeStringAlternately();
        System.out.println(mergeStringAlternately.mergeAlternately("ab", "pqrs"));

        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(121));

        TwoSum twoSum = new TwoSum();
        int[] arr = twoSum.twoSum(new int[]{-3, 4, 3, 90}, 0);
        for (int integer : arr) {
            System.out.println(integer);
        }
        RomanToInt romanToInt = new RomanToInt();
        System.out.println(romanToInt.romanToInt("MCMXCIV"));
        */
    }
}
