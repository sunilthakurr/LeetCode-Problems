//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public List<String> AllParenthesis(int n) 
    {
        // Write your code here
        List<String> list = new ArrayList<>();
        generate(n, 0, 0, "", list);
        return list;
    }
    public static void generate(int n, int oCount, int cCount, String str, List<String> list){
        if(cCount == n){
            list.add(str);
            return;
        }
        if(oCount < n){
            generate(n, oCount + 1, cCount, str + '(', list);
        }
        if(cCount < oCount){
            generate(n, oCount, cCount + 1, str + ')', list);
        }
    }
}