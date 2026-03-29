class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        
        res[0] = firstOccurence(nums, target);
        res[1] = lastOccurence(nums, target);
        return res;
    }
    private int firstOccurence(int[] nums, int target) {
        int ans = -1;

        int si = 0;
        int ei = nums.length - 1;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (nums[mid] >= target) {
                if (nums[mid] == target) {
                    ans = mid;
                }
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }
        return ans;
    }

    private int lastOccurence(int[] nums, int target) {
        int ans = -1;

        int si = 0;
        int ei = nums.length - 1;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (nums[mid] <= target) {
                if (nums[mid] == target) {
                    ans = mid;
                }
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }
        return ans;
    }
}