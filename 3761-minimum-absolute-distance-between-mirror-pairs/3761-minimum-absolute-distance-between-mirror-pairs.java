class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            } else {
                List<Integer> list = map.get(nums[i]);
                list.add(i);
                map.put(nums[i], list);
            }
        }
        // System.out.println(map.toString());
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int rev = reverse(nums[i]);
            if (!map.containsKey(rev)) {
                continue;
            }
            List<Integer> list = map.get(rev);
            int idx = lowerBound(list, i);
            if (idx == -1) {
                continue;
            }
            // System.out.println("idx:- "+i+" list:- "+list.toString()+" idx:- "+idx);
            res = Math.min(res, idx - i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    private int lowerBound(List<Integer> list, int idx) {
        int res = -1;
        int si = 0, ei = list.size() - 1;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (list.get(mid) <= idx) {
                si = mid + 1;
            } else {
                res = list.get(mid);
                ei = mid - 1;
            }
        }
        return res;
    }
    private int reverse(int num) {
        int res = 0;

        while (num != 0) {
            res *= 10;
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}