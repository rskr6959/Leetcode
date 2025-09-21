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
        ListNode sentinel = new ListNode(Integer.MIN_VALUE, head);
        ListNode pred = sentinel;
        ListNode leader = sentinel;
        int steps = 0;
        while(steps<n){
            leader = leader.next;
            steps++;
        }
        ListNode follower = sentinel;
        while(leader != null){
            leader = leader.next;
            pred = follower;
            follower = follower.next;
        } 
        pred.next = follower.next;
    return sentinel.next;
    }
}