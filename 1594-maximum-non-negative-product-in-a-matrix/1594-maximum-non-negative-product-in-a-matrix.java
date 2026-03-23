class Solution {
    static int mod = (int) 1e9 + 7;
    class Pair {
        long first;
        long second;

        public Pair(long first, long second) {
            this.first = first;
            this.second = second;
        }
    }
    public int maxProductPath(int[][] grid) {
        return solve(grid);
    }
    private int solve(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Pair[][] arr = new Pair[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    arr[i][j] = new Pair(grid[i][j], grid[i][j]);
                } else if(i == 0) {
                    Pair pair = arr[i][j - 1];
                    arr[i][j] = new Pair(pair.first * grid[i][j], pair.second * grid[i][j]);
                } else if(j == 0) {
                    Pair pair = arr[i - 1][j];
                    arr[i][j] = new Pair(pair.first * grid[i][j], pair.second * grid[i][j]);
                } else {
                    Pair p1 = arr[i][j - 1];
                    Pair p2 = arr[i - 1][j];

                    int val = grid[i][j];

                    long op1 = Math.min(p1.first * val, Math.min(p1.second * val, Math.min(p2.first * val, p2.second * val)));
                    long op2 = Math.max(p1.first * val, Math.max(p1.second * val, Math.max(p2.first * val, p2.second * val)));

                    op2 = Math.max(op1, op2);
                    if (op1 > 0) {
                        op1 = op2;
                    }
                    
                    // if (op1 > 0) op1 %= mod;
                    // if (op2 > 0) op2 %= mod;

                    // op1 %= mod;
                    // op2 %= mod;

                    arr[i][j] = new Pair(op1, op2);
                }
            }
        }
        Pair res = arr[m - 1][n - 1];
        long ans = Math.max(res.first, Math.max(res.second, -1));
        return ans == -1 ? -1: (int)(ans % mod);
    }
}