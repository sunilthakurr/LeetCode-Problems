class Solution {
    class Pair {
        int row;
        int col;

        public Pair (int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        int[][] res = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    res[i][j] = 0;
                } else {
                    res[i][j] = bfs(mat, i, j);
                }
            }
        }
        return res;
    }

    private int bfs(int[][] mat, int row, int col) {
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));

        int cnt = 0;
        boolean flag = false;

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            flag = false;

            for (int i = 0; i < 4; i++) {
                int nrow = pair.row + drow[i];
                int ncol = pair.col + dcol[i];

                if (nrow >= 0 && nrow < mat.length && ncol >= 0 && ncol < mat[0].length) {
                    if (mat[nrow][ncol] == 0) {
                        ++cnt;
                        return cnt;
                    } else {
                        q.add(new Pair(nrow, ncol));
                        flag = true;
                    }
                }
            }
            if (flag) ++cnt;
        }
        return -1;
    }
}