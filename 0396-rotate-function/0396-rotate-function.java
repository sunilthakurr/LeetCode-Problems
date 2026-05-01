class Solution {
    public int maxRotateFunction(int[] nums) {
        return solve(nums);
    }

    private int solve(int[] nums) {
        
        int res = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            res += (nums[i] * i);
            sum += nums[i];
        }

        int prev = res;

        for (int i = 1; i < nums.length; i++) {
            int curr = prev + sum - (nums.length * nums[nums.length - i]);
            res = Math.max(res, curr);
            prev = curr;
        }
        return res;
    }
}