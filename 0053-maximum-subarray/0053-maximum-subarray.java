class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int maxElement = max;

        for(int i = 0; i < nums.length; ++i){
// we use maxElement for incase every element is negative then we can easily return the maximum element
            // maxElement = Math.max(maxElement, nums[i]); 
            sum += nums[i];
            max = Math.max(max, sum);
            if(sum < 0)
                sum = 0;
        }
        // return Math.max(max, maxElement);
        return max;
    }
}