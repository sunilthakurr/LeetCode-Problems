//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            String T = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.checkCompressed(S,T));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int checkCompressed(String S, String T) {
        // code here
       boolean flag = false;
        int i = 0 , j = 0;
        while(j<T.length() && i<S.length()){
            char ch = T.charAt(j);
            if(Character.isDigit(ch)){
                int n = ch - '0'; // Or we can use Character.getNumericValue(ch);
                while(j<T.length()-1 && Character.isDigit(T.charAt(j+1))){
                    n = n*10 + Character.getNumericValue(T.charAt(j+1));
                    j++;
                }
                if(n>S.length()-i)
                return 0;
                while(i<S.length() && n!=1){
                    i++;
                    n--;
                }
            }
            else{
               // flag = true;
                if(ch != S.charAt(i)){
                    return 0;
                }
            }
                j++;
                i++;
        }
        // if(flag == false)
        // return 0;
        return 1;
    }
}