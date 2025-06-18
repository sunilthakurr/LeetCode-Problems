/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode head1 = headA;
        ListNode head2 = headB;

        while (headA != null && headB != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        if (headA == null) {
            while (headB != null) {
                head2 = head2.next;
                headB = headB.next;
            }
        }
        if (headB == null) {
            while(headA != null) {
                head1 = head1.next;
                headA = headA.next;
            }
        }
        while(head1 != null && head2 != null) {
            if(head1 == head2) return head1;
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }
}