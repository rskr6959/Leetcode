class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid == null)
        return 0;
        int islands = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int x = 0; x < m; x++){
            for(int y = 0; y < n; y++){
                if(grid[x][y] == '1'){
                bfs(grid, x, y);
                islands++;
            }
        }
        }
    return islands;
    }
    private void bfs(char[][] grid, int startx, int starty){
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startx, starty});
        grid[startx][starty] = '0';
        while(!q.isEmpty()){
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            for(int[] neighbor : getNeighbors(x, y, m, n)){
                int nx = neighbor[0];
                int ny = neighbor[1];
                if(grid[nx][ny] == '1'){
                    grid[nx][ny] = '0';
                    q.offer(new int[]{nx, ny});
                }
            }
        }
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