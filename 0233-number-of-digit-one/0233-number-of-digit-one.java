class Solution {
    int[][][] dp;
    String str;
    public int countDigitOne(int n) {
        return count(n);
    }

    private int count(int n) {
        str = String.valueOf(n);
        int len = str.length();

        // length --> tight --> count of 1
        dp = new int[len + 1][2][10];

        for (int[][] dp1: dp) {
            for (int[] dp2: dp1) {
                Arrays.fill(dp2, -1);
            }
        }
        return memo(0, 1, 0);
    }

    private int memo(int pos, int tight, int count_of_1) {
        if (pos == str.length()) return count_of_1;

        if (dp[pos][tight][count_of_1] != -1) {
            return dp[pos][tight][count_of_1];
        }

        int limit = (tight == 1) ? str.charAt(pos) - '0': 9;

        int res = 0;
        for (int digit = 0; digit <= limit; digit++) {
            int nextTight = (tight == 1 && digit == limit) ? 1: 0;

            if (digit == 1) {
                res += memo(pos + 1, nextTight, count_of_1 + 1);
            } else {
                res += memo(pos + 1, nextTight, count_of_1);
            } 
        }
        return dp[pos][tight][count_of_1] = res;
    }
}