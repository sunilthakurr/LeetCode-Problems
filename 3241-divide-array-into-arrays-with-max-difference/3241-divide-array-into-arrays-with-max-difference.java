class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n =  nums.length;
        int[][] res = new int[n / 3][3];

        int[] arr;
        int x = 0;
        for (int i = 2; i < nums.length; i+= 3) {
            if (nums[i] - nums[i - 2] > k) return new int[0][0];
            arr = new int[3];
            arr[0] = nums[i - 2];
            arr[1] = nums[i - 1];
            arr[2] = nums[i];
            res[x] = (arr);
            x++;
        }
        return res;
    }
}