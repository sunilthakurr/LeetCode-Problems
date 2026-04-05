class Solution {
    public int maxProduct(int[] nums) {
        
        int n = nums.length;
        int leftProduct = 1;
        int rightProduct = 1;

        int res = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (leftProduct == 0) leftProduct = 1;
            if (rightProduct == 0) rightProduct = 1;

            leftProduct *= nums[i];
            rightProduct *= nums[n - i - 1];
            
            res = Math.max(res, Math.max(leftProduct, rightProduct));
        }
        return res;
    }
}