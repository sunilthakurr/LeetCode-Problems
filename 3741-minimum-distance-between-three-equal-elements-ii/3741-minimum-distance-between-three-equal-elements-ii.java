class Solution {
    public int minimumDistance(int[] nums) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];

            if (!map.containsKey(val)) {
                map.put(val, new ArrayList<>());
            }
            List<Integer> list = map.get(val);
            list.add(i);
            map.put(val, list);
        }

        int ans = Integer.MAX_VALUE;
        for (Integer key: map.keySet()) {
            List<Integer> res = map.get(key);
            if (res.size() < 3) {
                continue;
            }
            for (int i = 2; i < res.size(); i++) {
                ans = Math.min(ans, Math.abs(res.get(i - 2) - res.get(i - 1)) + Math.abs(res.get(i - 1) - res.get(i)) + Math.abs(res.get(i) - res.get(i - 2)));
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}