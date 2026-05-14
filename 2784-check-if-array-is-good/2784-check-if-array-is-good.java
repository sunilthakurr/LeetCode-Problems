class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n];

        for (int num: nums) {
            if (num >= n) return false;
            freq[num]++;

            if (freq[num] > 1 && num != (n - 1)) return false;
            if (freq[num] > 2 && num == (n - 1)) return false;
        }
        return true;
    }
}