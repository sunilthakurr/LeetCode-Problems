class Solution {
    public int findPeakElement(int[] nums) {
        return solve(nums);
    }
    private int solve(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        
        int si = 0;
        int ei = nums.length - 1;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (mid > 0 && mid < nums.length - 1) {
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    return mid;
                } else if (nums[mid] < nums[mid - 1]) {
                    ei = mid - 1;
                } else {
                    si = mid + 1;
                }
            }
            if (mid == 0) {
                if (nums[0] > nums[1]) {
                    return 0;
                } else {
                    return 1;
                }
            }
            if (mid == nums.length - 1) {
                if (nums[nums.length - 1] > nums[nums.length - 2]) {
                    return nums.length - 1;
                } else {
                    return nums.length - 2;
                }
            }
        }
        return -1;
    }
}