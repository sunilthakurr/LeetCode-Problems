class Solution {
    public int[] constructTransformedArray(int[] nums) {

        int n = nums.length;
       int[] res = new int[n];

       for (int i = 0; i < n; i++) {
            int idx = -1;
            if (nums[i] >= 0) {
                idx = (i + nums[i]) % n;
            } else {
                int val = Math.abs(nums[i]) % n;
                if (val <= i) {
                    idx = i - val;
                } else {
                    val -= i;
                    idx = n - val;
                }
            }
            res[i] = nums[idx];
       }
       return res;
    }
}