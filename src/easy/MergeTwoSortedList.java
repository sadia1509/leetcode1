package easy;

import common.ListNode;

import java.util.Arrays;

public class MergeTwoSortedList {


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //int [] merged = new int[m+n];
        //System.arraycopy(nums1, 0,  merged, 0, m);
        System.arraycopy(nums2, 0,  nums1, m, n);
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    //list1 = 1,2,4
    ListNode merge(ListNode list1, int value) {
        ListNode newNode = new ListNode(value);
        ListNode elem = list1;
        while (elem.next != null) {
            if (elem.next.val > value) break;
            else elem = elem.next;
        }
        newNode.next = elem.next;
        elem.next = newNode;
        return list1;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list2 == null) return list1;
        else if (list1 == null) return list2;
        else {
            if (list1.val <= list2.val) {
                merge(list1, list2.val);
                return mergeTwoLists(list1, list2.next);
            } else {
                merge(list2, list1.val);
                return mergeTwoLists(list2, list1.next);
            }
        }
    }
}


