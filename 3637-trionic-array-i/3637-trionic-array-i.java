class Solution {
    public boolean isTrionic(int[] nums) {
        int f1 = 0;
        int f2 = 0;
        int f3 = 0;
        int i = 1;
        
        while (i < nums.length && nums[i] > nums[i - 1]) {
            i++;
            f1 = 1;
        }
        while (i < nums.length && nums[i] < nums[i - 1]) {
            i++;
            f2 = 1;
        }
        while (i < nums.length && nums[i] > nums[i - 1]) {
            i++;
            f3 = 1;
        }
        return f1 + f2 + f3 == 3 && i == nums.length;
    }
}