class Solution {
    public int[] applyOperations(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len-1; i++)
        {
            if(nums[i] == nums[i+1])
            {
                nums[i] = nums[i] << 1;
                nums[i+1] = 0;
            }
        }

        for(int i = 0, j = 0; i < len; i++)
        {
            if(nums[i] != 0)
            {
                int dup = nums[i];
                nums[i] = nums[j];
                nums[j] = dup;
                j++;
            }
        }
        return nums;
    }
}