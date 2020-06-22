import java.util.*;

public class Code {
  public static void main(String[] args) {
    Node root = new Node(1);
    Node left = new Node(2);
    Node right = new Node(3);
    root.left = left;
    root.right = right;
    left.left = new Node(4);
    left.right = new Node(5);
    right.left = new Node(6);
    right.right = new Node(7);
    
    int currLevel = 0, prevValue = 0;
    
    Queue<NodeLevel> que = new ArrayDeque<>();
    que.add(new NodeLevel(root, 0));
    
    while(!que.isEmpty()) {
      NodeLevel n = que.poll();
      int level = n.level;
      if(level != currLevel) {
        System.out.println(prevValue);
        currLevel = level;
      }
      
      prevValue = n.node.val;
      if(n.node.left !=null) que.add(new NodeLevel(n.node.left, n.level+1));
      if(n.node.right !=null) que.add(new NodeLevel(n.node.right, n.level+1));
    }
    System.out.println(prevValue);
  }
  
  public static class Node {
    Node left;
    Node right;
    int val;
    
    Node(int x) {
      val = x;
    }
  }
  
  public static class NodeLevel {
    Node node;
    int level;
    
    NodeLevel(Node n, int x) {
      node = n;
      level = x;
    }
  }
}
