class Solution {
    public int minMoves(int[] nums) {
        return solve(nums);
    }

    private int solve(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        int res = 0;
        int min = nums[0];
        int max = nums[n - 1];
        int ei = n - 1;
        
        int i = 1;
        while (min != max) {
            int diff = max - min;
            res += diff;
            
            min += diff;
            max = nums[n - 1 - i] + res;
            i++;
        }
        return res;
    }
}



// 1 3 4 5 8
// 8 10 11 12 8.   +7
// 12 14 15 12 12.  +4
// 15 17 15 15 15.  +3
// 17 17 17 17 17.  +2

