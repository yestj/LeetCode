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
    public ListNode mergeKLists(ListNode[] lists) {
        
        if (lists == null || lists.length == 0) return null;

        return mergeLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeLists(ListNode[] lists, int start, int end) { 
        
        if (start == end) return lists[start];
        
        if (start + 1 == end) return merge(lists[start], lists[end]);

        int mid = start + (end - start) / 2;
        ListNode left = mergeLists(lists, start, mid);
        ListNode right = mergeLists(lists, mid + 1, end);
        return merge (left, right);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode tmp = new ListNode(0);
        ListNode curr = tmp;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        curr.next = (l1 != null) ? l1 : l2;

        return tmp.next;
    }
}