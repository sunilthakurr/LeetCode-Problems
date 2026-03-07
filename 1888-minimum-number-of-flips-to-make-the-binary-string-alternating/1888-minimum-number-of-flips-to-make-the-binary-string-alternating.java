class Solution {
    public int minFlips(String s) {
        return solve(s);
    }
    private int solve(String str) {
        int n = str.length();
        int[][] pre = new int[n][2];

        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            pre[i][0] = (i == 0 ? 0 : pre[i - 1][1]) + (ch == '1' ? 1 : 0);
            pre[i][1] = (i == 0 ? 0 : pre[i - 1][0]) + (ch == '0' ? 1 : 0);
        }
        int ans = Math.min(pre[n - 1][0], pre[n - 1][1]);

        if (n % 2 == 0) {
            return ans;
        }
        int[][] suf = new int[n][2];

        for (int i = n - 1; i >= 0; i--) {
            char ch = str.charAt(i);

            suf[i][0] = (i == n - 1 ? 0 : suf[i + 1][1]) + (ch == '1' ? 1 : 0);
            suf[i][1] = (i == n - 1 ? 0 : suf[i + 1][0]) + (ch == '0' ? 1 : 0);
        }

        for (int i = 0; i < n - 1; i++) {
            ans = Math.min(ans, pre[i][0] + suf[i + 1][0]);
            ans = Math.min(ans, pre[i][1] + suf[i + 1][1]);
        }
        return ans;
    }
}