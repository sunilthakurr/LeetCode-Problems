class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;

        int[][] res = new int[n][m];

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(isWater[i][j] == 1){
                    res[i][j] = 0;
                    q.add(new int[]{i, j});
                }
                else{
                    res[i][j] = -1;
                }
            }
        }
        int[] rDir = {0, 1, 0, -1};
        int[] cDir = {1, 0, -1, 0};
        while(!q.isEmpty()) {
            int row = q.peek()[0];
            int col = q.peek()[1];
            q.poll();

            for(int i = 0; i < 4; i++) {
                int newRow = row + rDir[i];
                int newCol = col + cDir[i];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && res[newRow][newCol] == -1) {
                    res[newRow][newCol] = res[row][col] + 1;
                    q.add(new int[]{newRow, newCol});
                }
            }
        }
        return res;
    }
}
