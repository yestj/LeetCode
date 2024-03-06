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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode st = dummy;
        ListNode ed = dummy;

        for (int i = 0; i < n + 1; i++) {
            st = st.next;
        }

        while (st != null) {
            st = st.next;
            ed = ed.next;
        }

        ed.next = ed.next.next;

        return dummy.next;
    }
}