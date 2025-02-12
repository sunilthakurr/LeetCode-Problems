class Solution {
    public int maximumSum(int[] nums) {
       HashMap<Integer, Integer> map = new HashMap<>();
       int res = -1;

       for(int i = 0; i < nums.length; i++) {
            int sum = digitSum(nums[i]);
            if(map.containsKey(sum)) {
                res = Math.max(res, nums[i] + map.get(sum));
                map.put(sum, Math.max(map.get(sum), nums[i]));
            }
            else {
                map.put(sum, nums[i]);
            }
       }
       return res;
    }
    public static int digitSum(int num) {
        int sum = 0;
        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}