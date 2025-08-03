class Solution {
    private List<Integer> topoSort = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] req : prerequisites){
            int src = req[0];
            int dst = req[1];
            // adjList.get(src).add(dst);
            adjList.get(dst).add(src);
        }
        int[] visited = new int[n];
        int[] arrival = new int[n];
        int[] departure = new int[n];
        Arrays.fill(visited, -1);
        Arrays.fill(arrival, -1);
        Arrays.fill(departure, -1);
        for(int v = 0; v <n; v++){
            if(visited[v] == -1){
                if(dfs(adjList, v, visited, arrival, departure))
                return new int[0];
            }
        }
    Collections.reverse(topoSort);
    int[] result = new int[topoSort.size()];
    for (int i = 0; i < topoSort.size(); i++) {
    result[i] = topoSort.get(i);
    }
    return result;
    }
    private boolean dfs(List<List<Integer>> adjList, int source, int[] visited, int[] arrival, int[] departure){
        int timestamp = 0;
        visited[source] = 1;
        arrival[source] = timestamp++;
        for(int neighbor : adjList.get(source)){
            if(visited[neighbor] == -1){
            if(dfs(adjList, neighbor, visited, arrival, departure))
            return true;
            }
            else{
                if(departure[neighbor] == -1)
                return true;
            }
        }
        departure[source] = timestamp++;
        topoSort.add(source);
        return false;
    }
}