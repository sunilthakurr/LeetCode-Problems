class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                if (colors[i] != colors[j]) {
                    res = Math.max(res, j - i);
                    break;
                }
            }
        }
        return res;
    }
}