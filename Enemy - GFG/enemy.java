//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] a = IntArray.input(br, 3);
            int n = a[0],m=a[1],k=a[2];
            
            int[][] e = IntMatrix.input(br, a[2], 2);
            
            Solution obj = new Solution();
            int res = obj.largestArea(n,m,k,e);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


       

class Solution {
    public static int largestArea(int n,int m,int k,int[][] enemy) {
        // code here
        if(k==0)
      return n*m;
       ArrayList<Integer> li_row = new ArrayList<Integer>();
       ArrayList<Integer> li_col = new ArrayList<Integer>();
        for(int i=0;i<k;i++)
      {
          li_row.add(enemy[i][0]);
      }
         for(int i=0;i<k;i++)
      {
          li_col.add(enemy[i][1]);
      }
      li_row.add(n+1);
      li_col.add(m+1);
       Collections.sort(li_row);
       Collections.sort(li_col);
       
       int maxm_row=li_col.get(0)-1;
      for(int i=1;i<k+1;i++)
      {
          int temp=li_col.get(i)-li_col.get(i-1)-1;
          maxm_row=Math.max(temp,maxm_row);
      }
      int maxm_col=li_row.get(0)-1;
      for(int i=1;i<k+1;i++)
      {
          int temp=li_row.get(i)-li_row.get(i-1)-1;
          maxm_col=Math.max(temp,maxm_col);
      }
      //System.out.println("r"+maxm_row+"c"+maxm_col);
      return maxm_row*maxm_col;


    }
}
 
