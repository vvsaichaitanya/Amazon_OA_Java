import java.util.*;

public class Code {
  public static void main(String[] args) {
    int[][] edges = new int[][]{{1, 0}, {0, 2}, {0, 3}, {3, 4}, {4, 2}};
		int n = 5;
    List<Integer>[] graph = new ArrayList[n];
    boolean[] res = new boolean[1];
    boolean[] visited = new boolean[n];
    
    for(int[] e: edges) {
      if(graph[e[0]] == null) graph[e[0]] = new ArrayList<>();
      if(graph[e[1]] == null) graph[e[1]] = new ArrayList<>();
      graph[e[0]].add(e[1]);
      graph[e[1]].add(e[0]);
    }
    
    hasCycle(-1, 0, graph, visited, res);
    
    System.out.println(res[0]);
  }
  
  public static void hasCycle(int parent, int n, List<Integer>[] graph, boolean[] visited, boolean[] res) {
    if(visited[n]) {
      res[0] = true;
      return;
    }
    
    visited[n] = true;
    for(int i = 0; !res[0] && i < graph[n].size(); i++) {
      int neighbour = graph[n].get(i);
      if(parent == neighbour) continue;
      hasCycle(n, neighbour, graph, visited, res);
    }
  }
}
