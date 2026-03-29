class Solution {
    public int searchInsert(int[] nums, int target) {
        return solve(nums, target);
    }
    private int solve(int[] nums, int target) {
        int si = 0;
        int ei = nums.length - 1;
        int ans = -1;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] <= target) {
                // ans = mid;
                si = mid + 1;
            } else {
                ans = mid;
                ei = mid - 1;
            }
        }
        return ans == -1 ? nums.length : ans;
    }
}