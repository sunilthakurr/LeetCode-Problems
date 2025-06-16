class Solution {
    public int maximumDifference(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int res = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                max = nums[i];
            }
            if (nums[i] > max) {
                max = nums[i];
                res = Math.max(res, max - min);
            }
        }
        return res;
    }
}