class Solution {
    public long coloredCells(int n) {
        return solve((long)n);
    }
    public long solve(long n) {
        long a = 1;
        long d = 2;
        long sn = (n * (2 * a + (n - 1) * d)) / 2;
        n -= 1;
        long snn = (n * (2 * a + (n - 1) * d)) / 2;

        return sn + snn;
    }
}