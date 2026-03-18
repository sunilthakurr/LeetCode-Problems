class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        return solve(grid, k);
    }
    private int solve(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;

        int[][] arr = new int[row][col];

        int cnt = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    arr[i][j] = grid[i][j];
                } else if (i == 0) {
                    arr[i][j] = arr[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    arr[i][j] = arr[i - 1][j] + grid[i][j];
                } else {
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1] + grid[i][j] - arr[i - 1][j - 1];
                }
                if (arr[i][j] <= k) {
                    ++cnt;
                }
            }
        }
        return cnt;
    }
}