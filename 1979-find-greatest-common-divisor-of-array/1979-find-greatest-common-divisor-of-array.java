class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int a = nums[0];
        int b = nums[nums.length - 1];
        return gcd(a, b);
        
    }
    public static int gcd(int a, int b){
        int temp = Math.min(a, b);
        int count = 0;
        for(int i = 1; i <=temp; ++i){
            if(a % i == 0 && b % i == 0)
                count = i;
        }
        return count;
    }
}