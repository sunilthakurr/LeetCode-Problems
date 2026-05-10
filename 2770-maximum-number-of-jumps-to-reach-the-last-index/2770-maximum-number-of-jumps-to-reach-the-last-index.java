class Solution {
    public int maximumJumps(int[] nums, int target) {
        return solve(nums, target);
    }

    private int solve(int[] nums, int target) {
        int n = nums.length;

        int[]dp = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = Math.abs(nums[i] - nums[j]);

                if (diff <= target) {
                    if (j != 0 && dp[j] == 0) {
                        continue;
                    }
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n - 1] == 0 ? -1 : dp[n - 1];
    }
}