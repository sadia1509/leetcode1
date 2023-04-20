package easy;

import common.ListNode;

public class DeleteDuplicateFromList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        ListNode n = head;
        while (n.next != null) {
            if (n.val == n.next.val) {
                n.next = n.next.next;
            } else n = n.next;
        }
        return head;
    }
}
