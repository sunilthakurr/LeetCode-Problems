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
        ListNode fastPointer = head;
        while(n > 1) {
            fastPointer = fastPointer.next;
            n--;
        }
        ListNode slowPointer = head;
        ListNode prev = head;
        System.out.println(fastPointer.val);
        if (fastPointer.next == null) return head.next;
        while(fastPointer.next != null) {
            prev = slowPointer;
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        System.out.println(prev.val);
        System.out.println(slowPointer.val);
        prev.next = slowPointer.next;
        // System.out.println(prev.val+" "+slowPointer.val+" "+fastPointer);
        return head;
    }
}