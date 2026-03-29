class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return solve(nums1, nums2);
    }
    private double solve(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        boolean isEvenLength = (n + m) % 2 == 0;
        int medianIndex = (n + m) / 2;

        int idx1 = 0;
        int idx2 = 0;

        int ans = 0;

        int val = 0;
        while (medianIndex >= 0) {
            if (idx1 >= nums1.length) {
                val = nums2[idx2];
                ++idx2;
            } else if (idx2 >= nums2.length) {
                val = nums1[idx1];
                ++idx1;
            } else if (nums1[idx1] >= nums2[idx2]) {
                val = nums2[idx2];
                ++idx2;
            } else {
                val = nums1[idx1];
                ++idx1;
            }
            
            if (isEvenLength && medianIndex == 1) {
                System.out.println(val);
                ans += val;
            }
            if (medianIndex == 0) {
                System.out.println(val);
                ans += val;
            }
            --medianIndex;
        }
        if (isEvenLength) {
            return (ans / 2.0);
        }
        return ans * 1.0;
    }
}