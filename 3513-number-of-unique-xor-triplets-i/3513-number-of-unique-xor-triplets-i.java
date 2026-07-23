class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        if (n <= 2) return n;
        if (n == 3) return 4;

        int res = 4;
        int flag = 2;
        for (int i = 4; i <= n; i++) {
            if (i == flag * 2) {
                res *= 2;
                flag *= 2;
            }
        }
        return res;
    }
}