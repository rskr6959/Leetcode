class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<double[]>[] adjList = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adjList[i] = new ArrayList<>();
        }
        for(int i = 0; i < edges.length; i++){
            int src = edges[i][0];
            int dst = edges[i][1];
            double w = -Math.log(succProb[i]);
            adjList[src].add(new double[]{dst, w});
            adjList[dst].add(new double[]{src, w});
        }
        double[] captured = new double[n];
        Arrays.fill(captured, -1.0);
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(a[0], b[0]));
        pq.offer(new double[]{0, start_node});
        while(!pq.isEmpty()){
            double[] top = pq.poll();
            double dist = top[0];
            int node = (int) top[1];
            if(captured[node] != -1.0)
            continue;
            captured[node] = dist;
            for(double[] edge : adjList[node]){
                int neighbor = (int) edge[0];
                double w = edge[1];
                if(captured[neighbor] == -1.0){
                    pq.offer(new double[]{captured[node] + w, neighbor});
                }
            }
        }
    if(captured[end_node] != -1.0){
        return Math.exp(-captured[end_node]);
    }else{
        return 0.0;
    }
    }
}