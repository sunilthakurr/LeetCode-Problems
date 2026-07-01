class Solution {
    
    class Pair {
        int row;
        int col;
        int dist;

        public Pair(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int m = grid.get(0).size();

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.add(new Pair(i, j, 0));
                    dist[i][j] = 0;
                }
            }
        }

        int[] drow = {-1, 0, +1, 0};
        int[] dcol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Pair pair = q.poll();

            for (int i = 0; i < 4; i++) {
                int nrow = pair.row + drow[i];
                int ncol = pair.col + dcol[i];

                // System.out.println(nrow+" "+ncol+" "+pair.dist);

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
                    if (dist[nrow][ncol] > pair.dist + 1) {
                        q.add(new Pair(nrow, ncol, pair.dist + 1));
                        dist[nrow][ncol] = pair.dist + 1;
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(dist));
        // return -1;

        boolean[][] vis = new boolean[n][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.offer(new int[]{dist[0][0], 0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int safe = curr[0];
            int x = curr[1];
            int y = curr[2];

            if (x == n - 1 && y == n - 1)
                return safe;

            if (vis[x][y])
                continue;

            vis[x][y] = true;

            for (int k = 0; k < 4; k++) {
                int newX = x + drow[k];
                int newY = y + dcol[k];

                if (newX >= 0 && newX < n && newY >= 0 && newY < n
                        && !vis[newX][newY]) {

                    int newSafe = Math.min(safe, dist[newX][newY]);
                    pq.offer(new int[]{newSafe, newX, newY});
                }
            }
        }

        return -1;
    }
}