class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] {0, 0, 0});
        Map<String, Integer> captured = new HashMap<>();
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int dist = top[0];
            int x = top[1];
            int y = top[2];
            String key = x + "," + y;
            if(captured.containsKey(key)) continue;
            captured.put(key, dist);
            if(x == m - 1 && y == n - 1) return dist;
            for(int[] dir : dirs){
                int nx = dir[0] + x;
                int ny = dir[1] + y;
                if(nx >=0 && nx <= m - 1 && ny >= 0 && ny <= n - 1){
                    String nKey = nx + "," + ny;
                    if(captured.containsKey(nKey)) continue;
                    int newEffort = Math.max(dist, Math.abs(heights[x][y] - heights[nx][ny]));
                    pq.offer(new int[] {newEffort, nx, ny});
                }
            }
        }
    return 0; 
    }
}