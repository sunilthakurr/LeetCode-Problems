//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int n = Integer.parseInt(input[0]); 
            int m = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.baseEquiv(n,m));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    String baseEquiv(int n, int m)
    {
        // code here
        for(int i = 2; i <= 32; ++i){
            int temp = baseLength(n, i);
            if(temp == m)
                return "Yes";
        }
        return "No";
        
    }
    // public static String BaseAnyToAny(int n, m){
    //     int Olen = (int)Math.log10(num) + 1;
        
    //     if(Olen < m){
    //         int si = 2;
    //         int ei = 9;
            
    //         while(si <= ei){
    //             int mid = (si + ei)/2;
            
    //         }
    //     }
    // }
    public static int baseLength(int num, int base){
        ArrayList<Integer> Updated = new ArrayList<Integer>(10);
        while(num >= base){
            int temp = num % base;
            Updated.add(temp);
            num /= base;
        }
        Updated.add(num);
        return Updated.size();
    }
    
}