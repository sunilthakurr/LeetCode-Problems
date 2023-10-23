class Solution {
    public boolean isPowerOfFour(int n) {
        if(n<=0){
            return false;
        }
        double temp = Math.log(n)/Math.log(4);
        return temp==Math.floor(temp);
    }
}