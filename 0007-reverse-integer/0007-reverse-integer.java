class Solution {
    public int reverse(int x) {
       
        int count = 0;
        int rem = 0;
        long newnum = 0;
        int n =x;
        if(n < 0)
            count =1;
        // int length = Math.log10(x) + 1;
       x= Math.abs(x);
        while(x != 0){
            rem = x % 10;
            x /= 10;
            newnum = newnum * 10 + rem ;
        }
         if(newnum < -2147483648 || newnum > 2147483647)
            return 0;
         if(count == 1)
            return (-1*(int)newnum);
         else
             return (int)newnum;
        
    }
}