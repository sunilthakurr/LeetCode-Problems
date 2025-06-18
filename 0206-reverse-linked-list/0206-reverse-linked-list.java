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
    public ListNode reverseList(ListNode head) {
        // ListNode newHead = null;
        // ListNode prev = null;
        // int cnt = 0;
        // while (head != null) {
        //     ++cnt;
        //     newHead = head;
        //     newHead.next = prev;
        //     prev = head;
        //     System.out.println(prev.val+" "+head.val);
        //     head = head.next;
        // }
        // System.out.println(cnt);
        // return newHead;
        if (head == null) return head;

        ListNode prev = null, curr = head, next = head.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (curr != null) {
                next = next.next;
            }
        }
        return prev;
    }
}