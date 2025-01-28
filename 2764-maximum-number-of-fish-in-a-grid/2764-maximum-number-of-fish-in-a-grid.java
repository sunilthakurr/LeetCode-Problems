class Solution {
    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        int res = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] != 0 && vis[i][j] == 0) {
                    int curMax = dfs(i, j, grid, vis);
                    res = Math.max(res, curMax);
                }
            }
        }
        return res;
    }
    static int[] drow = {-1, 0, +1, 0};
    static int[] dcol = {0, +1, 0, -1};

    public static int dfs(int row, int col, int[][] grid, int[][] vis) {
        int n = grid.length;
        int m = grid[0].length;

        int sum = grid[row][col];
        vis[row][col] = 1;
        for(int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 
            && grid[nrow][ncol] != 0) {
                vis[nrow][ncol] = 1;
                sum += dfs(nrow, ncol, grid, vis);
            }
        }
        return sum;
    }
}