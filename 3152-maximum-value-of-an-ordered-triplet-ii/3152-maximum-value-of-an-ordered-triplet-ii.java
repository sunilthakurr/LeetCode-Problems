class Solution {
    public long maximumTripletValue(int[] nums) {
        long res = 0, iMax = 0, dMax = 0;

        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dMax * nums[i]);
            dMax = Math.max(dMax, iMax - nums[i]);
            iMax = Math.max(iMax, nums[i]);
        }
        return res;
    }
}