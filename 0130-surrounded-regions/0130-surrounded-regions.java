class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        boolean[][] vis = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                    if (!vis[i][j] && board[i][j] == 'O') {
                        vis[i][j] = true;
                        dfs(board, vis, i, j, drow, dcol);
                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'X') continue;
                else if (vis[i][j] == false) board[i][j] = 'X';
            }
        }
        // return board;
    }
    
    private void dfs(char[][] board, boolean[][] vis, int row, int col, int[] drow, int[] dcol) {
        
        vis[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if (nrow >= 0 && nrow < vis.length && ncol >= 0 && ncol < vis[0].length && board[nrow][ncol] == 'O' && vis[nrow][ncol] == false) {
                vis[nrow][ncol] = true;
                dfs(board, vis, nrow, ncol, drow, dcol);
            }
        }
    }
}