class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max = maxSubarraySum(nums);
        int min = minSubarraySum(nums);
        return Math.max(max, Math.abs(min));
    }
    public int maxSubarraySum(int[] nums) {
        int curMax = 0;
        int maxSoFar = nums[0];

        for(int i = 0; i < nums.length; i++) {
            curMax += nums[i];

            if(maxSoFar < curMax) {
                maxSoFar = curMax;
            }
            if(curMax < 0) {
                curMax = 0;
            }
        }
        return maxSoFar;
    }
    public int minSubarraySum(int[] nums) {
        int curMin = 0;
        int minSoFar = nums[0];

        for(int i = 0; i < nums.length; i++) {
            curMin += nums[i];
            
            if(minSoFar > curMin) {
                minSoFar = curMin;
            }
            if(curMin > 0) {
                curMin = 0;
            }
        }
        return minSoFar;
    }
}