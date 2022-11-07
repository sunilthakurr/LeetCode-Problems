class Solution {
    public boolean isPalindrome(int x) {
        int y=x,r=0,s=0;
        if(x<0)
            return false;
        while(x!=0) {
            r=x%10;
            x=x/10;
            s=s*10 +r;
        }
        if(y==s)
            return true;
        else
            return false;
        
    }
}