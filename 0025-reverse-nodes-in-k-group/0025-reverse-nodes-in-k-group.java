/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        int cnt = 0;

        while(curr != null) {
            cnt++;
            if (cnt % k == 0) {
                prev = reverse(prev, curr.next);
                curr = prev.next;
            } else {
                curr = curr.next;
            }
        }

        return dummy.next;
    }

    private ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = start.next;
        ListNode curr = prev.next;
        ListNode next; 
        while (curr != end) {
            next = curr.next;
            curr.next = start.next;
            start.next = curr;
            curr = next;
        }
        prev.next = end;
        return prev;
    }
}