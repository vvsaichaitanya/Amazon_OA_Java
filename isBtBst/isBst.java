public class Code {
  static int preValue = Integer.MIN_VALUE;
  static boolean flag = false;
  
  public static void main(String[] args) {
    		Node root = new Node(40);
        Node thirty = new Node(30);
        thirty.left = new Node(10);
        thirty.right = new Node(36);
        Node fifty = new Node(50);
        fifty.left = new Node(55);
        fifty.right = new Node(70);
        root.left = thirty;
        root.right = fifty;
    		isBST(root);
    		System.out.println(flag);
  }
  
  public static void isBST(Node n) {
		if(n.left != null) isBST(n.left);
    if(n.val < preValue) {
      flag = false; 
      return;
    }
    else {flag = true; preValue = n.val;}
    if(n.right != null) isBST(n.right);
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
