class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int minutes = 0;
        int fresh = 0;
        for(int i = 0 ; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2)
                q.offer(new int[]{i, j});
                if(grid[i][j] == 1)
                fresh++;
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            boolean infected = false;
            for(int i = 0; i < size; i++){
            int[] current = q.poll();
            int row = current[0];
            int col = current[1];
            for(int[] neighbor : getNeighbors(row, col, m , n)){
                int nx = neighbor[0];
                int ny = neighbor[1];
                if(grid[nx][ny] == 1){
                    grid[nx][ny] = 2;
                    fresh--;
                    q.offer(new int[]{nx, ny});
                    infected = true;
                }
            }
        }
        if(infected) minutes++;
        }
    return (fresh == 0) ? minutes : -1;
    }

    private List<int[]> getNeighbors(int x, int y, int m, int n){
        List<int[]> neighbors = new ArrayList<>();
        if (x + 1 < m) neighbors.add(new int[]{x + 1, y});
        if (y + 1 < n) neighbors.add(new int[]{x, y + 1});
        if (x - 1 >= 0) neighbors.add(new int[]{x - 1, y});
        if (y - 1 >= 0) neighbors.add(new int[]{x, y - 1});
        return neighbors;
    }
}