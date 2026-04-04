class Solution {
    class Pair {
        int row;
        int col;

        public Pair (int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int numIslands(char[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];
        int result = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    ++result;
                    bfs(grid, visited, new Pair(i, j));
                }
            }
        }
        return result;
    }

    public void bfs(char[][] grid, boolean[][] visited, Pair pair) {
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        Queue<Pair> q = new LinkedList<>();
        q.add(pair);
        
        int row = pair.row;
        int col = pair.col;
        
        visited[row][col] = true;

        while (!q.isEmpty()) {

            Pair node = q.poll();
            row = node.row;
            col = node.col;

            for (int i = 0; i < drow.length; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if (nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && !visited[nrow][ncol] && grid[nrow][ncol] == '1') {
                    q.add(new Pair(nrow, ncol));
                    visited[nrow][ncol] = true;
                }
            }
        }
    }
}