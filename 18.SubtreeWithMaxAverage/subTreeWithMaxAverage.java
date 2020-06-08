import java.util.*;

public class Code {
	static Double maxAvg = 0.0;
    static int maxNode = -1;
  
    public static void main(String[ ] args) {
        Node eleven = new Node(11);
        Node two = new Node(2);
        Node three = new Node(3);
        List<Node> nodes = new ArrayList<>();
        nodes.add(eleven);
        nodes.add(two);
        nodes.add(three);
        Node twelve = new Node(12, nodes);
        Node fifteen = new Node(15);
        Node eight = new Node(8);
        nodes = new ArrayList<>();
        nodes.add(fifteen);
        nodes.add(eight);
        Node eighteen = new Node(18, nodes);
        nodes = new ArrayList<>();
        nodes.add(twelve);
        nodes.add(eighteen);
        Node root = new Node(20, nodes);
        
        Queue<Node> que = new ArrayDeque<>();
        que.add(root);
        
      	if (root == null) System.out.println("-1");
      	int[] res = getAvgNode(root);
      
        System.out.println(maxNode);
    }
  
  public static int[] getAvgNode(Node el) {
    if (el.children == null) return new int[]{el.val, 1};
    int sum = el.val;
    int nodes = 1;
    
    for (Node elem: el.children) {
      int[] leaf = getAvgNode(elem);
      sum += leaf[0];
      nodes += leaf[1];
    }
    
	double avg  = sum / nodes;
    if(avg > maxAvg) {
      maxAvg = avg;
      maxNode = el.val;
    }
    return new int[]{sum, nodes};
  }
    
    public static class Node {
        public int val;
        public List<Node> children;
        public Node(int _val) { val = _val; }
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
    }
	}
}
