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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode dummy = head;
        
        if(l1 == null & l2 == null){
            return l1;
        }
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        
        while(l1 != null || l2 != null) {
            if((l1!=null) && (l2 == null || l1.val <= l2.val)) {
                head.next = new ListNode(l1.val);
                head = head.next;
                l1 = l1.next;
            }
            if((l2!= null) && (l1 == null || l2.val <= l1.val)) {
                head.next = new ListNode(l2.val);
                head = head.next;
                l2 = l2.next;
            }
        }
        
        return dummy.next;
    }
}