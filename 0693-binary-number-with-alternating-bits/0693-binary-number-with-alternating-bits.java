class Solution {
    public boolean hasAlternatingBits(int n) {
        int firstBit = n & 1;
        n >>= 1;

        while (n != 0) {
            if (firstBit == (n & 1)) {
                return false;
            }
            firstBit = n & 1;
            n >>= 1;
        }
        return true;
    }
}