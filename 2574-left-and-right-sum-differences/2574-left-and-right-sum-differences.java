class Solution {
    public int[] leftRightDifference(int[] nums) {
        int rightSum = 0;
        int leftSum = 0;
        for(int i : nums){
            rightSum += i;
        }
        int temp;
        for(int i = 0; i < nums.length; ++i){
            rightSum -= nums[i];
            temp = nums[i];
            nums[i] = Math.abs(rightSum - leftSum);
            leftSum += temp;
        }
        return nums;
    }
}