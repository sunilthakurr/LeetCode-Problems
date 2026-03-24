class Solution {
    int mod = (int) 12345;
    public int[][] constructProductMatrix(int[][] grid) {
        return solve(grid);
    }
    private int[][] solve(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] res = new int[n][m];

        int[][] suffix = new int[n][m];

        long mult = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = (int)mult;
                mult = (int)(mult * (grid[i][j] % mod)) % mod;
                System.out.println(i+" "+j+" --> "+res[i][j]);
            }
        }
        mult = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                // suffix[i][j] = mult;
                res[i][j] = (int)(res[i][j] * mult) % mod;
                // res[i][j] = (res[i][j] * grid[i][j]) % mod;
                mult = (mult * grid[i][j]) % mod;
                // res[i][j] = (res[i][j] * suffix[i])
            }
        }
        return res;
    }
}