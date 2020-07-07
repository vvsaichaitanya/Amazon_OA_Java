import java.util.*;

public class Code {
  public static void main(String[] args) {
    int n = 7;
    int[][] edges = new int[][]{{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}};
    		List<Integer>[] graph = new ArrayList[n];
        Set<Integer> res = new HashSet<>();
        if(n == 0 || edges.length == 0) System.out.println("empty");
        int[] nodeTimeStamp = new int[n];
        int[] time = new int[1];
        boolean[] visited = new boolean[n];
        
        for(int[] pair: edges) {
            if(graph[pair[0]] == null) graph[pair[0]] = new ArrayList<>();
            if(graph[pair[1]] == null) graph[pair[1]] = new ArrayList<>();
            graph[pair[0]].add(pair[1]);
            graph[pair[1]].add(pair[0]);
        }
        
        findCriticalConnection(-1, 0, graph, time, visited, nodeTimeStamp, res);
    		System.out.println(res);
  }
  
  public static void findCriticalConnection(int parent, int node, List<Integer>[] graph, int[] time, boolean[] visited, int[] nodeTimeStamp, Set<Integer> res) {
        visited[node] = true;
        nodeTimeStamp[node] = time[0]++;
        int currentTime = nodeTimeStamp[node];
        
        for(int neighbour: graph[node]) {
            if(parent == neighbour) continue;
            if(!visited[neighbour]) findCriticalConnection(node, neighbour, graph, time, visited, nodeTimeStamp, res);
            nodeTimeStamp[node] = Math.min(nodeTimeStamp[node], nodeTimeStamp[neighbour]);
            if(currentTime < nodeTimeStamp[neighbour]) {
              res.add(node);
//               res.add(neighbour);
            }
        }
    }
}
