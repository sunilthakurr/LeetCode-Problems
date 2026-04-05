class Solution {
    public int change(int amount, int[] coins) {
        return numberOfWays(amount, coins);
    }
    private int numberOfWays(int amount, int[] coins) {

        int n = coins.length;

        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {

                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                }
                if (i == 0) continue;

                if (coins[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];
    }
}