/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int st = 1;
        int en = n;
       int mid = st + (en - st)/2;
        while(guess(mid) != 0){
            
            
            
            if(guess(mid) == -1)
                en = mid - 1;
            else
                st = mid + 1; 
            mid = st + (en - st)/2;
                
            
        }
        return mid;
        
    }
}