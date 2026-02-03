class Solution {
    public int cherryPickup(int[][] grid) {
        int[][][] container = new int[grid.length][grid[0].length][grid[0].length];
        for (int i = 0; i < container.length; i++) {
            for (int j = 0; j < container[0].length; j++) {
                Arrays.fill(container[i][j], -1);
            }
        }
        return solve(0, 0, grid[0].length - 1, grid, container);
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