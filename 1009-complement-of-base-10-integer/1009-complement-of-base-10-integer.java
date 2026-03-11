class Solution {
    public int bitwiseComplement(int n) {
        return solve(n);
    }
    private int solve(int n) {
        if (n == 0) return 1;
        int res = 0;
        int cnt = 0;
        while (n != 0) {
            int reverseBit = (n & 1) ^ 1;
            reverseBit <<= cnt;
            res += reverseBit;
            ++cnt;
            n >>= 1;
        }
        return res;
    }
}