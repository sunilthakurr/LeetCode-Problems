class Solution {
    public int maxSubArray(int[] nums) {
        return solve(nums);
    }
    
    private int solve(int[] nums) {
        int n = nums.length;

        int ans = nums[0];
        int curr_sum = 0;

        for (int i = 0; i < n; i++) {
            curr_sum += nums[i];
            if (curr_sum > ans) {
                ans = curr_sum;
            }

            if (curr_sum < 0) {
                curr_sum = 0;
            }
        }
        return ans;
    }
}