class Solution {
    public int cherryPickup(int[][] grid) {
        // int[][][] container = new int[grid.length][grid[0].length][grid[0].length];
        // for (int i = 0; i < container.length; i++) {
        //     for (int j = 0; j < container[0].length; j++) {
        //         Arrays.fill(container[i][j], -1);
        //     }
        // }
        // return solve(0, 0, grid[0].length - 1, grid, container);
        return iterDP(grid);
    }
    private int iterDP(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        dp[0][0][m - 1] = grid[0][0] + grid[0][m - 1];
        
        int ans = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    int max = -1;

                    for (int x = -1; x <= 1; x++) {
                        for (int y = -1; y <= 1; y++) {
                            if (j + x >= 0 && j + x < m && k + y >= 0 && k + y < m) {
                                max = Math.max(max, dp[i - 1][j + x][k + y]);
                            }
                        }
                    }
                    // if (j == k) {
                    //     dp[i][j][k] = max + grid[i][j];
                    // } else {
                    if (max != -1) {
                        if (j == k) {
                            dp[i][j][k] = max + grid[i][j];
                        } else {
                            dp[i][j][k] = max + grid[i][j] + grid[i][k];
                        }
                    }
                    ans = Math.max(ans, dp[i][j][k]);
                }
            }
        }
        return ans;
    }
    private int solve(int row, int col1, int col2, int[][] grid, int[][][] container) {
        if (col1 < 0 || col1 >= grid[0].length || col2 < 0 || col2 >= grid[0].length) {
            return 0;
        }
        if (row == grid.length - 1) {
            if (col1 == col2) {
                return grid[row][col1];
            } else {
                return grid[row][col1] + grid[row][col2];
            }
        }

        if (container[row][col1][col2] != -1) return container[row][col1][col2];

        int res = -1;
        int curr = col1 == col2 ? grid[row][col1] : grid[row][col1] + grid[row][col2];

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int ans = curr + solve(row + 1, col1 + i, col2 + j, grid, container);
                res = Math.max(res, ans);
            }
        }
        return container[row][col1][col2] = res;
    }
}