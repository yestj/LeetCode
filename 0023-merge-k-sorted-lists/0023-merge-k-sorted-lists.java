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
        List<Integer> mergeList = new ArrayList<>();
        for (ListNode l : lists) {
            ListNode curr = l;
            while (curr != null) {
                mergeList.add(curr.val);
                curr = curr.next;
            }
        }
        Collections.sort(mergeList);
        
        ListNode ans = new ListNode();
        ListNode tmp = ans;
        for (int i : mergeList) {
            tmp.next = new ListNode(i);
            tmp = tmp.next;
        }

        return ans.next;
    }
}