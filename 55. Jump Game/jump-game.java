class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if(len == 0 || len == 1)
            return true;
        if(nums[0] == 0)
            return false;

        int[] dp = new int[len];
    
    dp[0]=nums[0];
    
    for(int i = 1; i< len; i++){
        dp[i] = Math.max(dp[i-1]-1, nums[i]);
        if(dp[i]==0 && i!= len -1){
            return false;
        }
    }
    return true;
        
    }
}
