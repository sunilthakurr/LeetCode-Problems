class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        
        int res = 0;
        
        int cnt = 0;

        // 9 7 6  5 2 2
        // 9 7
        // 5 2
        for (int i = cost.length - 1; i >= 0; i--) {
            cnt += 1;
            if (cnt == 3) {
                cnt = 0;
                continue;
            }
            res += cost[i];
        }
        return res;
    }
}