class Solution {
    public int minMoves(int[] nums) {
        return solve(nums);
    }

    private int solve(int[] nums) {
        int n = nums.length;

        int min = Integer.MAX_VALUE;

        for (int el: nums) {
            min = Math.min(min, el);
        }

        int res = 0;
        for (int el: nums) {
            res += (el - min);
        }
        return res;
    }
}