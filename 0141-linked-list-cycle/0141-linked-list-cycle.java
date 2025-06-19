/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode temp = head;

        while (head != null && head.next != null) {
            head = head.next.next;
            temp = temp.next;
            if (head == temp) return true;
        }
        return false;
    }
}