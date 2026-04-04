class Solution {

    class Pair {
        int row;
        int col;

        public Pair (int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int numEnclaves(int[][] grid) {
    
        int row = grid.length;
        int col = grid[0].length;

        boolean[][] vis = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                    if (!vis[i][j] && grid[i][j] == 1) {
                        bfs(grid, vis, i, j);
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    ++res;
                }
            }
        }
        return res;
    }
    private void bfs(int[][] grid, boolean[][] vis, int row, int col) {

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        vis[row][col] = true;

        while (!q.isEmpty()) {
            Pair pair = q.poll();

            row = pair.row;
            col = pair.col;

            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if (nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && !vis[nrow][ncol] && grid[nrow][ncol] == 1) {
                    vis[nrow][ncol] = true;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
    }
}