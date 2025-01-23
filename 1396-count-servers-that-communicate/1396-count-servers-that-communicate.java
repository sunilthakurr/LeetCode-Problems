class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;


        Set<Integer> row = new HashSet<>();
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
                row.add(i);
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
                    if(row.contains(i)) {
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
