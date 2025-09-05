class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] adjList = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++){
            adjList[i] = new ArrayList<>();
        }
        for(int[] edge : times){
            int src = edge[0];
            int dst = edge[1];
            int w = edge[2];
            adjList[src].add(new int[]{dst, w});
        }
        int[] captured = new int[n + 1];
        Arrays.fill(captured, -1);
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        q.offer(new int[]{0, k});
        int numCaptured = 0;
        int lastDist = 0;
        while(!q.isEmpty()){
            int[] top = q.poll();
            int dist = top[0];
            int node = top[1];
            if(captured[node] != -1) continue;
            captured[node] = dist;
            numCaptured++;
            lastDist = dist;
            for(int[] neighbor : adjList[node]){
                int next = neighbor[0];
                int w = neighbor[1];
                if(captured[next] == -1){
                    q.offer(new int[]{dist + w, next});
                }
            }
        }
        return (numCaptured == n) ? lastDist : -1;        
    }
}