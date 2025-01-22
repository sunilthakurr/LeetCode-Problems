class Solution {
    public int change(int amount, int[] coins) {
        // int[][] container = new int[amount + 1][coins.length];
        // for(int i = 0; i < container.length; i++) {
        //     Arrays.fill(container[i], -1);
        // }
        // return rec(coins, amount, coins.length - 1, container);
        return iter(coins, amount);
    }
    public int rec(int[] coins, int amount, int ind, int[][] container) {
        if(ind < 0) return 0;
        if(amount == 0) return 1;

        if(container[amount][ind] != -1) {
            return container[amount][ind];
        }

        if(coins[ind] <= amount) {
            return container[amount][ind] = rec(coins, amount, ind - 1, container) + rec(coins, amount - coins[ind], ind, container);
        }
        else {
            return container[amount][ind] = rec(coins, amount, ind - 1, container);
        }
    }
    public int iter(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= amount; j++) {
                // if(i == 0) dp[i][j] = 0;
                if(j == 0) dp[i][j] = 1;

                if(i > 0 && coins[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
                else if(i > 0) {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];
    }
}