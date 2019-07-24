/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        boolean returnNull = true;
        for(ListNode node : lists){
            // if all nodes are null return null
            if(node != null) returnNull = false;
            while(node != null){
                heap.add(node.val);
                node = node.next;
            }
        }
        if(returnNull) return null;
        
        ListNode answer = new ListNode(heap.poll());
        ListNode ptr = answer;
        while(!heap.isEmpty()){
            ptr.next = new ListNode(heap.poll());
            ptr = ptr.next;
        }
        return answer;
    }
}