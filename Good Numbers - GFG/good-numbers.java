//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int L = Integer.parseInt(S[0]);
            int R = Integer.parseInt(S[1]);
            int D = Integer.parseInt(S[2]);
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.goodNumbers(L, R, D);
            for (int i : ans) System.out.print(i + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<Integer> goodNumbers(int L, int R, int D) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = L; i <= R; ++i){
            if(isGood(i, D))
                list.add(i);
        }
        return list;
    }
    public static boolean isGood(int num, int D){
        
        int sum = 0;
        int rem = 0;
        
        if(num % 10 == 0 && D != 0)
            num /= 10;
        
        while(num != 0){
            rem = num % 10;
            if(rem <= sum)
                return false;
            if(rem == D)
                return false;
            
            
            else{
                sum += rem;
                num /= 10;
            }
        }
        return true;
    }
}