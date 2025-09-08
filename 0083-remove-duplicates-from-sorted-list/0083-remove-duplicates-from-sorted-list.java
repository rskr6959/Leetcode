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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode(Integer.MIN_VALUE, head);
        ListNode pred = sentinel;
        ListNode curr = head;
        while(curr != null){
            if(pred.val == curr.val){
                pred.next = curr.next;
                curr = curr.next;
            }
            else{
                pred = curr;
                curr = curr.next;
            }
        }
        return sentinel.next;
        
    }
}