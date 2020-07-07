class Solution {
    // We record the timestamp that we visit each node. For each node, we check every neighbor except its parent and return a smallest timestamp in all its neighbors. If this timestamp is strictly less than the node's timestamp, we know that this node is somehow in a cycle. Otherwise, this edge from the parent to this node is a critical connection
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = new ArrayList[n];
        List<List<Integer>> res = new ArrayList<>();
        if(n == 0 || connections.size() == 0) return res;
        int[] nodeTimeStamp = new int[n];
        int[] time = new int[1];
        boolean[] visited = new boolean[n];
        
        for(List<Integer> pair: connections) {
            if(graph[pair.get(0)] == null) graph[pair.get(0)] = new ArrayList<>();
            if(graph[pair.get(1)] == null) graph[pair.get(1)] = new ArrayList<>();
            graph[pair.get(0)].add(pair.get(1));
            graph[pair.get(1)].add(pair.get(0));
        }
        
        findCriticalConnection(-1, 0, graph, time, visited, nodeTimeStamp, res);
        return res;
    }
    
    public void findCriticalConnection(int parent, int node, List<Integer>[] graph, int[] time, boolean[] visited, int[] nodeTimeStamp, List<List<Integer>> res) {
        visited[node] = true;
        nodeTimeStamp[node] = time[0]++;
        int currentTime = nodeTimeStamp[node];
        
        for(int neighbour: graph[node]) {
            if(parent == neighbour) continue;
            if(!visited[neighbour]) findCriticalConnection(node, neighbour, graph, time, visited, nodeTimeStamp, res);
            nodeTimeStamp[node] = Math.min(nodeTimeStamp[node], nodeTimeStamp[neighbour]);
            if(currentTime < nodeTimeStamp[neighbour]) res.add(new ArrayList(Arrays.asList(node, neighbour)));
        }
    }
}