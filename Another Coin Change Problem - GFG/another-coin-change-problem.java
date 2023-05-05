//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int N;
            N = Integer.parseInt(br.readLine());

            int K;
            K = Integer.parseInt(br.readLine());

            int target;
            target = Integer.parseInt(br.readLine());

            int[] coins = IntArray.input(br, N);

            Solution obj = new Solution();
            boolean res = obj.makeChanges(N, K, target, coins);

            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int  recursion(int i,int k,int target,int coins[],int dp[][][])
    {
        if(i==-1||k==-1)
        {
            return 0;
        }
        if(k==0&&target==0)
        {
            return 1;
        }
        if(dp[i][k][target]!=-1)
        {
            return dp[i][k][target];
        }
        int take=0,nottake=0;
        if(coins[i]<=target)
        {
            take=recursion(i,k-1,target-coins[i],coins,dp);
        }
        nottake=recursion(i-1,k,target,coins,dp);
        return dp[i][k][target]=take|nottake;
    }
    public static boolean makeChanges(int N, int K, int target, int[] coins) {
        // code here
        int dp[][][]=new int[N][K+1][target+1];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<=K;j++)
            {
                for(int r=0;r<=target;r++)
                {
                    dp[i][j][r]=-1;
                }
            }
        }
        return (1==recursion(N-1,K,target,coins,dp));
    }
}