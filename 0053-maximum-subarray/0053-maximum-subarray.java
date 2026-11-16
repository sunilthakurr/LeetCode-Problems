class Solution {
    public int maxSubArray(int[] nums) {
        return divideAndConquer(nums, 0, nums.length - 1);
    }

    private int divideAndConquer(int[] nums, int si, int ei) {
        if (si == ei) return nums[si];

        int mid = si + (ei - si) / 2;
        int leftAns = divideAndConquer(nums, si, mid);
        int rightAns = divideAndConquer(nums, mid + 1, ei);
        int crossingSum = maxCrossingSum(nums, si, mid, ei);

        return Math.max(crossingSum, Math.max(leftAns, rightAns));
    }

    private int maxCrossingSum(int[] nums, int low, int mid, int high) {
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;

        for (int i = mid; i >= low; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }

        sum = 0;
        int rightSum = Integer.MIN_VALUE;

        for (int i = mid; i <= high; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }
        return Math.max(leftSum, Math.max(rightSum, rightSum + leftSum - nums[mid]));
    }
}