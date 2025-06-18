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
        int carry = 0;
        ListNode head = new ListNode(12);
        ListNode temp = head;
        int sum = 0;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + carry;
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            head.next = node;
            head = head.next;
        }
        while (l1 != null) {
            sum = l1.val + carry;
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            head.next = node;
            head = head.next;
        }
        while (l2 != null) {
            sum = l2.val + carry;
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            l2 = l2.next;
            head.next = node;
            head = head.next;
        }
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            head.next = node;
        }
        return temp.next;
    }
}