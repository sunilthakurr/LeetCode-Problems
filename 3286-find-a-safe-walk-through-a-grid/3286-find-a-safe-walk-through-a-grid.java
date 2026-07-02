class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();

        if (grid.get(0).get(0) == 1) {
            health -= 1;
        }
        if (health <= 0) {
            return false;
        }

        int[] drow = {-1, 0, +1, 0};
        int[] dcol = {0, +1, 0, -1};
        boolean[][] vis = new boolean[n][m];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.add(new int[]{health, 0, 0});

        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int remHealth = arr[0];
            int row = arr[1];
            int col = arr[2];

            // System.out.println(remHealth + " "+row+" "+col);

            if (remHealth <= 0) {
                return false;
            }

            if (row == n - 1 && col == m - 1) {
                return true;
            }

            if (vis[row][col]) {
                continue;
            }
            vis[row][col] = true;

            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol]) {
                    int newHealth = remHealth;
                    if (grid.get(nrow).get(ncol) == 1) {
                        newHealth -= 1;
                    }
                    pq.add(new int[] {newHealth, nrow, ncol});
                }
            }
        }
        return false;
    }
}