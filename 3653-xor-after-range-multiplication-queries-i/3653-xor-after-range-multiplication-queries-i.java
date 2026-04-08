class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        
        long[] arr = new long[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = (long) nums[i];
        }

        int mod = (int) 1e9 + 7;
        for (int i = 0; i < queries.length; i++) {
            int li = queries[i][0];
            int ri = queries[i][1];

            int ki = queries[i][2];
            int vi = queries[i][3];

            while (li <= ri) {
                arr[li] %= mod;
                arr[li] = (arr[li] * vi) % mod;
                li += ki;
            }
        }

        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= arr[i];
            // res %= mod;
        }
        return (int)res;
    }
}