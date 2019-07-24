/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        
        ListNode prev = null;
        ListNode cur = head;
        int count = 0;
        while(cur != null && count != k){
            count++;
            prev = cur;
            cur = cur.next;
        }
        if(count == k){
            ListNode next = head.next;
            ListNode prev1 = head;
            head.next = reverseKGroup(cur, k);
            head = next;
            count--;
            while(count != 0){
                next = head.next;
                head.next = prev1;
                prev1 = head;
                head = next;
                count--;
            }
        }
        else return head;
        
        return prev;
    }
}