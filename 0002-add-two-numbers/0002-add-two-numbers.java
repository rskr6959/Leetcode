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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode();
        ListNode result = sentinel;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        int c = 0;
        while(l1 != null || l2 != null){
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            int sum = val1 + val2 + c;
            result.next = new ListNode(sum % 10);
            result = result.next;
            c = sum / 10;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        } 
        if(c > 0)
        result.next = new ListNode(c);
    return sentinel.next;
    }
}