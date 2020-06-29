import java.util.*;

public class Code {
  static boolean f1, f2;
  
  public static void main(String[] args) {
    		Node root = new Node(1);
        Node thirty = new Node(2);
        thirty.left = new Node(4);
        thirty.right = new Node(5);
        Node fifty = new Node(3);
        fifty.left = new Node(6);
        fifty.right = new Node(7);
        root.left = thirty;
        root.right = fifty;
    		int preVal = 0;
    
    List<Integer> p1 = new ArrayList<>();
    Node res = getPath(root, 3, 2);
    System.out.println(f1 && f2? res.val:"el not found");
  }
  
	public static Node getPath(Node n, int n1, int n2) {
    if(n == null) {
      return null;
    }
    
    if(n.val == n1) {
      f1 = true;
      return n;
    }
    
    if(n.val == n2) {
      f2 = true;
      return n;
    }
    
    Node left = getPath(n.left, n1, n2);
    Node right = getPath(n.right, n1, n2);
    
    if(left != null && right != null) return n;
    else return left != null? left: right;
  }
  
  public static class Node {
    int val;
    Node left;
    Node right;
    
    Node(int x) {
      val = x;
    }
  }
}
