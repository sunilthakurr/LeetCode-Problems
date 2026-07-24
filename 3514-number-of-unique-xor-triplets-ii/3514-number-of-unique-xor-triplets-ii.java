class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        if (n == 1) return 1;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                set.add(nums[i] ^ nums[j]);
            }
        }
        // System.out.println(set.size());
        // Set<Integer> res = new HashSet<>();
        boolean[] arr = new boolean[2048];
        for (int el: set) {
            for (int val: nums) {
                arr[el ^ val] = true;
            }
        }
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) ++cnt;
        }
        return cnt;
    }
}