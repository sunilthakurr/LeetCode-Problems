class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int pre[] = new int[2 * n + 1];
        pre[n] = 1;
        int count = n;
        long result = 0, prefixSum = 0;
        for(int i = 0; i < n; i++) {
            if (nums[i] == target) {
                prefixSum += pre[count];
                ++count;
                ++pre[count];
            } else {
                --count;
                prefixSum -= pre[count];
                ++pre[count];
            }
            result += prefixSum;
        }
        return result;
    }
}