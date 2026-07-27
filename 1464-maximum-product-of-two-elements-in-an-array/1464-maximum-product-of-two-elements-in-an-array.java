class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sMax = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] >= max){
                sMax = max;
                max = nums[i];
            }
            else if(nums[i] > sMax){
                sMax = nums[i];
            }
        }
        return (max - 1) * (sMax - 1);
    }
}