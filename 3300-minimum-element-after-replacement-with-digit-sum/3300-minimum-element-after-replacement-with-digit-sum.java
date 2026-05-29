class Solution {
    public int minElement(int[] nums) {
        int res = Integer.MAX_VALUE;

        for (int el: nums) {
            res = Math.min(res, digitSum(el));
        }
        return res;
    }

    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}