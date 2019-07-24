/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        
        ListNode pt1 = head;
        ListNode evensHead = head.next;
        ListNode pt2 = head.next;
        while(pt1.next != null && pt2.next != null){
            pt1.next = pt1.next.next;
            pt1 = pt1.next;
            pt2.next = pt2.next.next;
            pt2 = pt2.next;
        }
        pt1.next = evensHead;
        return head;
    }
}