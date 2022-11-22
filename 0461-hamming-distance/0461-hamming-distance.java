class Solution {
    public int hammingDistance(int x, int y) {
        int num = x ^ y;
        return countSetBits(num);
        
    }
    static int countSetBits(int n)
    {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
}