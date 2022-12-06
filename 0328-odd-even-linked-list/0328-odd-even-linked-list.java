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
    public ListNode oddEvenList(ListNode head) {
        if(head == null)
			return head;
        ListNode temp1 = head;
		ListNode temp2 = head.next;
        ListNode evenHead = temp2;
        
        while(temp1.next != null && temp2.next != null){
            temp1.next = temp2.next;
            temp2.next = temp2.next.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        temp1.next = evenHead;
        return head;
    }
}