class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> res = new ArrayList<>();

        Arrays.sort(nums);

        int el = nums[0] + 1;
        for (int i = 1; i < nums.length; i++) {
            while(el < nums[i]) {
                res.add(el);
                el++;
            }
            el = nums[i] + 1;
        }
        return res;
    }
}