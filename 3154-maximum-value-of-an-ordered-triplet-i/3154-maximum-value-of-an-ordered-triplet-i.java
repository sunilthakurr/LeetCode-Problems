class Solution {
    public long maximumTripletValue(int[] nums) {
        long res = 0, iMax = 0, difMax = 0;

        for(int i = 0; i < nums.length; i++) {
            res = Math.max(res, difMax * nums[i]);
            difMax = Math.max(difMax, iMax - nums[i]);
            iMax = Math.max(iMax, nums[i]);
        }
        return res;
    }
}