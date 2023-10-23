class Solution {
    public boolean isPowerOfFour(int n) {
        if(n <= 0){
            return false;
        }
        double exp = Math.log(n) / Math.log(4);

        return exp == Math.floor(exp);
    }
}