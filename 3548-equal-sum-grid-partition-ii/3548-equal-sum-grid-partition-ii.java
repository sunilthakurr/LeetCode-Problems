import java.util.HashMap;

class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        boolean ans = false;

        if (grid.length == 1) {
            ans = ans || isArrayDivisible(grid[0]);
        }
        if (grid[0].length == 1) {
            int len = grid.length;
            int[] arr = new int[len];
            for (int i = 0; i < len; i++) arr[i] = grid[i][0];
            ans = ans || isArrayDivisible(arr);
        }
        if (grid.length == 2) {
            ans = ans || isTwoSizeTableDivisible(grid);
        }
        if (grid[0].length == 2) {
            ans = ans || isTwoColumnTableDivisible(grid);
        }
        if (grid.length > 2) {
            ans = ans || divisionRowWise(grid);
        }
        if (grid[0].length > 2) {
            ans = ans || divisionColWise(grid);
        }

        return ans;
    }

    private boolean isTwoSizeTableDivisible(int[][] grid) {
        long firstRowSum = 0;
        for (int el : grid[0]) firstRowSum += el;

        long secondRowSum = 0;
        for (int el : grid[1]) secondRowSum += el;

        if (firstRowSum == secondRowSum) return true;
        if (firstRowSum - grid[0][0] == secondRowSum) return true;
        if (firstRowSum - grid[0][grid[0].length - 1] == secondRowSum) return true;
        if (secondRowSum - grid[1][0] == firstRowSum) return true;
        if (secondRowSum - grid[1][grid[0].length - 1] == firstRowSum) return true;
        return false;
    }

    private boolean isTwoColumnTableDivisible(int[][] grid) {
        int rows = grid.length;
        long firstColSum = 0, secondColSum = 0;
        for (int i = 0; i < rows; i++) {
            firstColSum += grid[i][0];
            secondColSum += grid[i][1];
        }
        if (firstColSum == secondColSum) return true;
        if (firstColSum - grid[0][0] == secondColSum) return true;
        if (firstColSum - grid[rows - 1][0] == secondColSum) return true;
        if (secondColSum - grid[0][1] == firstColSum) return true;
        if (secondColSum - grid[rows - 1][1] == firstColSum) return true;
        return false;
    }

    private boolean isArrayDivisible(int[] arr) {
        int n = arr.length;
        long sum = 0;
        for (int el : arr) sum += el;

        long prefixSum = 0;
        for (int i = 0; i < n - 1; i++) {
            prefixSum += arr[i];
            long suffixSum = sum - prefixSum;

            if (prefixSum == suffixSum) return true;

            if (i >= 1) {
                if (prefixSum - arr[0] == suffixSum) return true;
                if (prefixSum - arr[i] == suffixSum) return true;
            }

            if (i < n - 2) {
                if (prefixSum == suffixSum - arr[i + 1]) return true;
                if (prefixSum == suffixSum - arr[n - 1]) return true;
            }
        }
        return false;
    }

    private boolean divisionRowWise(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        // Maps now use Long as key to handle potential overflows in difference logic
        HashMap<Long, Integer> prefixMap = new HashMap<>();
        HashMap<Long, Integer> suffixMap = new HashMap<>();

        long totalSum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                totalSum += grid[i][j];
                long val = (long) grid[i][j];
                suffixMap.put(val, suffixMap.getOrDefault(val, 0) + 1);
            }
        }

        long prefixSum = 0;
        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < col; j++) {
                long val = (long) grid[i][j];
                prefixSum += val;
                prefixMap.put(val, prefixMap.getOrDefault(val, 0) + 1);
                int freq = suffixMap.get(val);
                if (freq == 1) suffixMap.remove(val);
                else suffixMap.put(val, freq - 1);
            }

            long suffixSum = totalSum - prefixSum;

            if (prefixSum == suffixSum) return true;

            if (prefixSum - grid[0][0]     == suffixSum) return true;
            if (prefixSum - grid[0][col-1] == suffixSum) return true;
            if (prefixSum - grid[i][0]     == suffixSum) return true;
            if (prefixSum - grid[i][col-1] == suffixSum) return true;

            if (suffixSum - grid[i+1][0]       == prefixSum) return true;
            if (suffixSum - grid[i+1][col-1]   == prefixSum) return true;
            if (suffixSum - grid[row-1][0]     == prefixSum) return true;
            if (suffixSum - grid[row-1][col-1] == prefixSum) return true;

            if (i > 0 && col > 1 && prefixMap.containsKey(prefixSum - suffixSum)) return true;
            if (i < row - 2 && col > 1 && suffixMap.containsKey(suffixSum - prefixSum)) return true;
        }
        return false;
    }

    private boolean divisionColWise(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        HashMap<Long, Integer> prefixMap = new HashMap<>();
        HashMap<Long, Integer> suffixMap = new HashMap<>();

        long totalSum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                totalSum += grid[i][j];
                long val = (long) grid[i][j];
                suffixMap.put(val, suffixMap.getOrDefault(val, 0) + 1);
            }
        }

        long prefixSum = 0;
        for (int j = 0; j < col - 1; j++) {
            for (int i = 0; i < row; i++) {
                long val = (long) grid[i][j];
                prefixSum += val;
                prefixMap.put(val, prefixMap.getOrDefault(val, 0) + 1);
                int freq = suffixMap.get(val);
                if (freq == 1) suffixMap.remove(val);
                else suffixMap.put(val, freq - 1);
            }

            long suffixSum = totalSum - prefixSum;

            if (prefixSum == suffixSum) return true;

            if (prefixSum - grid[0][0]     == suffixSum) return true;
            if (prefixSum - grid[row-1][0] == suffixSum) return true;
            if (prefixSum - grid[0][j]     == suffixSum) return true;
            if (prefixSum - grid[row-1][j] == suffixSum) return true;

            if (suffixSum - grid[0][j+1]       == prefixSum) return true;
            if (suffixSum - grid[row-1][j+1]   == prefixSum) return true;
            if (suffixSum - grid[0][col-1]     == prefixSum) return true;
            if (suffixSum - grid[row-1][col-1] == prefixSum) return true;

            if (j > 0 && row > 1 && prefixMap.containsKey(prefixSum - suffixSum)) return true;
            if (j < col - 2 && row > 1 && suffixMap.containsKey(suffixSum - prefixSum)) return true;
        }
        return false;
    }
}