class Solution {
    int mod = (int)(1e9 + 7);
    public int numOfSubarrays(int[] arr) {
        int pSum = 0;
        int oddCount = 0;
        int evenCount = 1;
        int res = 0;

        for(int el: arr) {
            pSum += el;
            if(pSum % 2 == 0) {
                res += oddCount;
                evenCount++;
            }
            else {
                res += evenCount;
                oddCount++;
            }
            res %= mod;
        }
        return res;
    }
}