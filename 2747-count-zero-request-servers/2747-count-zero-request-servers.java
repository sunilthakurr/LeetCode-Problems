class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int q = queries.length;
        int[][] qs = new int[q][2];
        for (int i = 0; i < q; i++) {
            qs[i][0] = queries[i];
            qs[i][1] = i;
        }
        Arrays.sort(qs, (a, b) -> Integer.compare(a[0], b[0]));

        int[] cnt = new int[n + 1];
        int[] ans = new int[q];
        int active = 0;
        int left = 0, right = 0;
        int L = logs.length;

        for (int[] qq : qs) {
            int time = qq[0];
            int idx = qq[1];

            while (right < L && logs[right][1] <= time) {
                int s = logs[right][0];
                if (cnt[s] == 0) active++;
                cnt[s]++;
                right++;
            }

            while (left < right && logs[left][1] < time - x) {
                int s = logs[left][0];
                cnt[s]--;
                if (cnt[s] == 0) active--;
                left++;
            }

            ans[idx] = n - active;
        }
        return ans;
    }
}