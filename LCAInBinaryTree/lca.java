import java.util.*;

public class Code {
  static boolean found = false;
  
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
    getPath(root, 9, p1);
    System.out.println(p1);
    List<Integer> p2 = new ArrayList<>();
    found = false;
    getPath(root, 3, p2);
    System.out.println(p2);
    int length = p1.size() > p2.size()? p2.size():p1.size();
    
    for(int i = 0;i < length; i++) {
      if(p1.get(i) == p2.get(i)) {
        preVal = p1.get(i);
      } else break;
    }
    System.out.println(preVal);
  }
  
	public static void getPath(Node n, int val, List<Integer> res) {
    if(n.val == val) {
      found = true;
      res.add(n.val);
      return;
    }
    
    if(!found && n.left != null) {
      res.add(n.val);
      getPath(n.left, val, res);
      if(!found) res.remove(res.size() - 1);
    }
    if(!found && n.right != null) {
      res.add(n.val);
      getPath(n.right, val, res);
      if(!found) res.remove(res.size() - 1);
    }
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
