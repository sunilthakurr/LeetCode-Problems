class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        return solve(grid, k);
    }
    private int[][] solve(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;

        // int[] arr = new int[k * k];
        int[][] result = new int[row - k + 1][col - k + 1];
        for (int i =  0; i <= row - k; i++) {
            for (int j = 0; j <= col - k; j++) {
               result[i][j] = createArray(grid, k, i, j, i + k, j + k);
            //    result[i][j] = minAbsoluteValue(arr);
            }
        }
        return result;
    }
    private int createArray(int[][] grid, int k, int x1, int y1, int x2, int y2) {
        Set<Integer> set = new TreeSet<>();
        
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                set.add(grid[i][j]);
            }
        }
        

        if (set.size() <= 1) return 0;

        int[] arr = new int[set.size()];

        int ind = 0;
        for (int el: set) {
            arr[ind] = el;
            ind++;
        }
        return minAbsoluteValue(arr);

        // int prev = set.poll();
        // int ans = Integer.MAX_VALUE;
        // while (!set.isEmpty()) {
        //     int curr = set.poll();
        //     int currMin = Math.abs(curr - prev);
        //     prev = curr;
        //     ans = Math.min(ans, currMin);
        // }
        // return ans;
        // System.out.println(Arrays.toString(arr));
        // return arr;
    }
    private int minAbsoluteValue(int[] arr) {
        Arrays.sort(arr);

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int val = Math.abs(arr[i] - arr[i - 1]);
            ans = Math.min(ans, val);
        }
        return ans;
    }
}