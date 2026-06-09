class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;

        for (int el: nums) {
            min = Math.min(el, min);
            max = Math.max(el, max);
        }
        return (long)k * (max - min);
    }
}