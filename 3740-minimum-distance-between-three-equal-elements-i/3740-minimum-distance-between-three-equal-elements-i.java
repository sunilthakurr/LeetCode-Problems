class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        if (n < 3) return -1;

        int res = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];

            if (!set.contains(num)) {
                int lastPrev = -1;
                int nextPrev = -1;

                for (int j = 0; j < n; j++) {
                    if (nums[j] == num) {
                        if (lastPrev == -1 && nextPrev == -1) {
                            lastPrev = j;
                        } 
                        else if (lastPrev != -1 && nextPrev == -1) {
                            nextPrev = j;
                        } 
                        else {
                            int dist = Math.abs(lastPrev-nextPrev)
                                     + Math.abs(lastPrev-j)
                                     + Math.abs(nextPrev-j);

                            res = Math.min(res, dist);

                            lastPrev = nextPrev;
                            nextPrev = j;
                        }
                    }
                }
            }
            set.add(num);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}