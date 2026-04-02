class Solution {
    public int maximumAmount(int[][] coins) {
        int n = coins.length;
        int m = coins[0].length;

        // Initialize the DP array with MIN_VALUE
        int[][][] dp = new int[n][m][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }

        // Base case
        for (int k = 0; k < 3; k++) {
            if (coins[0][0] < 0 && k > 0) {
                dp[0][0][k] = 0; // If no negatives allowed, take 0
            } else {
                dp[0][0][k] = coins[0][0];
            }
        }

        // Fill DP table iteratively
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 3; k++) {
                    if (i == 0 && j == 0) continue; // Skip the base case

                    int a1 = Integer.MIN_VALUE, a2 = Integer.MIN_VALUE;

                    // Option 1: Regular addition
                    if (i > 0) a1 = dp[i - 1][j][k];
                    if (j > 0) a1 = Math.max(a1, dp[i][j - 1][k]);
                    if (a1 != Integer.MIN_VALUE) a1 += coins[i][j];

                    // Option 2: Use one "negative forgiveness" if possible
                    if (k > 0 && coins[i][j] < 0) {
                        if (i > 0) a2 = dp[i - 1][j][k - 1];
                        if (j > 0) a2 = Math.max(a2, dp[i][j - 1][k - 1]);
                    }

                    // Update dp[i][j][k]
                    dp[i][j][k] = Math.max(a1, a2);
                }
            }
        }

        // The result is the maximum amount at the bottom-right corner
        return dp[n - 1][m - 1][2];
    }
}
