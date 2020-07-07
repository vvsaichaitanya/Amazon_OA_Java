/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node ptr = head;
        
        while(ptr != null) {
            Node n = new Node(ptr.val);
            n.next = ptr.next;
            ptr.next = n;
            ptr = ptr.next.next;
        }
        
        ptr = head;
        
        while(ptr != null) {
            if(ptr.random != null) ptr.next.random = ptr.random.next;
            ptr = ptr.next.next;
        }
        
        ptr = head;
        Node ptr2 = ptr.next;
        head = ptr2;
        while(ptr != null && ptr.next != null) {
            ptr.next = ptr.next.next;
            if(ptr2 != null && ptr2.next != null) {
                ptr2.next = ptr2.next.next;
                ptr2 = ptr2.next;
            };
            ptr = ptr.next;
        }
        return head;
    }
}