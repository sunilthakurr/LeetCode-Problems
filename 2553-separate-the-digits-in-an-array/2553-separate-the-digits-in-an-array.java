class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = solve(nums);
        int[] res = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(list.size() - 1 - i);
        }
        return res;
    }

    private List<Integer> solve(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            int el = nums[i];
            while (el > 0) {
                list.add(el % 10);
                el /= 10;
            }
        }
        return list;
    }
}