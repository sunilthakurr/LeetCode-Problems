class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] delta = new int[2 * limit + 2];

        for (int i = 0; i < n / 2; i++) {
            int a = Math.min(nums[i], nums[n - 1 - i]);
            int b = Math.max(nums[i], nums[n - 1 - i]);

            delta[2] += 2;
            delta[a + 1] -= 1;
            delta[a + b] -= 1;
            delta[a + b + 1] += 1;
            delta[b + limit + 1] += 1;
        }

        int minMoves = n;
        int currentMoves = 0;
        for (int i = 2; i <= 2 * limit; i++) {
            currentMoves += delta[i];
            minMoves = Math.min(minMoves, currentMoves);
        }

        return minMoves;
    }
}