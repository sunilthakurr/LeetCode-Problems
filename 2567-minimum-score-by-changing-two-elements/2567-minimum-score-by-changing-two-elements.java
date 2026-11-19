class Solution {
    public int minimizeSum(int[] nums) {
        int len = nums.length;
        
        if(len <= 3)
            return 0;
        Arrays.sort(nums);
        // return Math.min((nums[len - 1] - nums[2]), Math.min(nums[1] - nums[len - 2], nums[len - 3] - nums[0]));
        int op1 = nums[len - 1] - nums[2];
        int op2 = nums[len - 3] - nums[0];
        int op3 = nums[len - 2] - nums[1];
        return Math.min(op1, Math.min(op2, op3));

        
    }
}