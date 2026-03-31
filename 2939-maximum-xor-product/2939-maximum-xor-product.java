class Solution {
    int mod = (int) 1e9 + 7;
    public int maximumXorProduct(long a, long b, int n) {
        long res = solve(a, b, n);
        return (int) res % mod;
    }
    private long solve(long a, long b, int n) {
        
        for (int i = n - 1; i >= 0; i--) {
            
            long mask = (long)1 << i;

            if ((a & mask) != 0 && (b & mask) != 0) {      // we can take this bit of x as 0
                continue;
            } else if ((a & mask) != 0) {
                if (a > b) {
                    a ^= mask;
                    b |= mask;
                }
                continue;
            } else if ((b & mask) != 0) {
                if (b > a) {
                    b ^= mask;
                    a |= mask;
                }
            } else {
                a |= mask;
                b |= mask;
            }
            
        }
        a = a % mod;
        b = b % mod;
        return (1L * a * b) % mod;
    }
}   