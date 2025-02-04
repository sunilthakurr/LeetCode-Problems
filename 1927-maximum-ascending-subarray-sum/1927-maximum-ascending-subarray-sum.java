class Solution {
    public int maxAscendingSum(int[] nums) {
        int max = nums[0];
        int curr_max = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]) {
                curr_max += nums[i];
            }
            else {
                curr_max = nums[i];
            }
            max = Math.max(max, curr_max);
        }
        return max;
    }
}