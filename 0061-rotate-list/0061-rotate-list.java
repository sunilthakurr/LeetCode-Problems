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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        int size = getSize(head);
        k %= size;
        if (k == 0) return head;

        ListNode temp = head;
        k = size - k;

        while (k > 1) {
            head = head.next;
            k -= 1;
        }
        ListNode newHead = head.next;
        head.next = null;

        ListNode flag = newHead;

        while (flag.next != null) {
            flag = flag.next;
        }
        flag.next = temp;
        return newHead;
    }

    private int getSize(ListNode head) {
        int size = 0;
        
        while (head != null) {
            ++size;
            head = head.next;
        }
        return size;
    }
}