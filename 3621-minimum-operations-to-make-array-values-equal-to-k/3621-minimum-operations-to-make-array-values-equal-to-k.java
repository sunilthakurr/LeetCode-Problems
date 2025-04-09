class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;

        for(int el: nums) {
            if(el != k)
                set.add(el);
            min = Math.min(min, el);
        }
        return min < k ? -1: set.size();
    }
}