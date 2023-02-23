//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            
            int [][] grid = new int[n][m];
            for(int i=0; i<n; i++)
            {
                String S1[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                {
                    grid[i][j] = Integer.parseInt(S1[j]);
                }
            }

            Solution ob = new Solution();
            System.out.println(ob.uniquePaths(n,m,grid));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {

    static int mod=1000000007;

    

    static int solve(int[][] grid,int n, int m)

    {

        if(m<0||n<0||grid[n][m]==0) return 0;

        

        if(m==0&&n==0) return 1;

        

        if(grid[n][m]!=1) return grid[n][m]; 

        

        return grid[n][m]=(solve(grid,n-1,m)%mod+solve(grid,n,m-1)%mod)%mod;

        

    }

    

    static int uniquePaths(int n, int m, int[][] grid) {

        // code here

        // grid[n-1][m-1]=1;

        

        

        return solve(grid,n-1,m-1);

        

    }

};

