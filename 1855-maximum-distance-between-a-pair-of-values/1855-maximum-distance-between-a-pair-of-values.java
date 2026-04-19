class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int res = 0;

        for (int i = 0; i < nums1.length; i++) {
            int el = nums1[i];
            int bs = binarySearch(nums2, i, el);

            if (bs == -1) {
                continue;
            }
            res = Math.max(res, bs - i);
        }
        return res;
    }
    
    private int binarySearch(int[] nums, int si, int target) {
        int res = -1;

        int ei = nums.length - 1;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (nums[mid] >= target) {
                res = mid;
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }
        return res;
    }
}