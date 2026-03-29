class Solution {
    public int search(int[] nums, int target) {
        int minIndex = findMinElementIndex(nums);

        int op1 = binarySearch(nums, 0, minIndex - 1, target);
        int op2 = binarySearch(nums, minIndex, nums.length - 1, target);

        return Math.max(op1, op2);
    }
    private int binarySearch(int[] nums, int si, int ei, int target) {
        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= target) {
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }
        return -1;
    }
    private int findMinElementIndex(int[] nums) {
        int si = 0;
        int ei = nums.length - 1;

        while (si <= ei) {
            if (nums[si] <= nums[ei]) {
                return si;
            }
            int mid = si + (ei - si) / 2;
            
            if (nums[si] <= nums[mid]) {
                si = mid + 1;
            } else {
                ei = mid;
            }
        }
        return -1;
    }
}