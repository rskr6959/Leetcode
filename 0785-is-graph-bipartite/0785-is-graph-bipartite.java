class Solution {
    public boolean isBipartite(int[][] graph) {
        List<List<Integer>> adjList = new ArrayList<>();
        int n = graph.length;
        // for(int i = 0; i < n; i++){
        //     adjList.add(new ArrayList<>());
        // }
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        int[] distance = new int[n];
        Arrays.fill(parent, -1);
        Arrays.fill(distance, -1);

        for(int v = 0; v < n; v++){
            if(!visited[v]){
                visited[v] = true;
                if(bfs(graph, v, adjList, visited, parent, distance) == false){
                return false;
                }
            }
        }
    return true;
    }
    private boolean bfs(int[][] graph, int node, List<List<Integer>> adjList, boolean[] visited, int[] parent, int[] distance){
        visited[node] = true;
        distance[node] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            int current = q.poll();
            for(int neighbor : graph[current]){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    parent[neighbor] = current;
                    distance[neighbor] = distance[current] + 1;
                    q.offer(neighbor);
                }
                else if(parent[current] != neighbor){
                    if(distance[current] == distance[neighbor])
                    return false;
                }
            }
        }
    return true;
    }
}

// we can solve by not having parent array..