class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        return solve(grid);
    }
    private boolean solve(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        long sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum += grid[i][j];
            }
        }
        if (sum % 2 != 0) return false;

        long curSum = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                curSum += grid[i][j];
            }
            if (curSum * 2 == sum) {
                return true;
            }
        }

        curSum = 0;
        for (int j = 0; j < m - 1; j++) {
            for (int i = 0; i < n; i++) {
                curSum += grid[i][j];
            }
            if (curSum * 2 == sum) {
                return true;
            }
        }
        return false;
    }
}