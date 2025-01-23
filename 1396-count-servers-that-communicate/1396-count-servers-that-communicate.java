class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] row = new int[n];
        int res = 0;
        for(int i = 0; i < n; i++) {
            int cnt = 0;
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    ++cnt;
                }  
            }
            if(cnt >= 2) {
                res += cnt;
                row[i] = 1;
            }
        }
        System.out.println(res);
        int alreadyCalculated = 0;
        for(int j = 0; j < m; j++) {
            int cnt = 0;
            alreadyCalculated = 0;
            for(int i = 0; i < n; i++) {
                if(grid[i][j] == 1) {
                    ++cnt;
                    if(row[i] == 1) {
                        System.out.println("alreayd :- "+i+" "+j);
                        ++alreadyCalculated;
                    }
                }
            }
            if(cnt >= 2) res += cnt - alreadyCalculated;
        }
        return res;
    }
}
