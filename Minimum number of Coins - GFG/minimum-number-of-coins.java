//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            List<Integer> numbers= new ArrayList<Integer>();
            numbers = ob.minPartition(N);
            for(int i: numbers){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static List<Integer> minPartition(int N)
    {
        // code here
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        int count = N / 2000;
        
        for(int i = 0; i < count; ++i){
            list.add(2000);
        }
        N %= 2000;
        count = N / 500;
        
        for(int i = 0; i < count; ++i){
            list.add(500);
        }
        N %= 500;
        count = N / 200;
        
        for(int i = 0; i < count; ++i){
            list.add(200);
        }
        N %= 200;
        count = N / 100;
        
        for(int i = 0; i < count; ++i){
            list.add(100);
        }
        N %= 100;
        count = N / 50;
        for(int i = 0; i < count; ++i){
            list.add(50);
        }
        N %= 50;
        count = N / 20;
        for(int i = 0; i < count; ++i){
            list.add(20);
        }
        N %= 20;
        count = N / 10;
        for(int i = 0; i < count; ++i){
            list.add(10);
        }
        // N %= 20;
        // count = N / 10;
        // for(int i = 0; i < count; ++i){
        //     list.add(10);
        // }
        N %= 10;
        count = N / 5;
        for(int i = 0; i < count; ++i){
            list.add(5);
        }
        N %= 5;
        count = N / 2;
        for(int i = 0; i < count; ++i){
            list.add(2);
        }
        N %= 2;
        count = N / 1;
        for(int i = 0; i < count; ++i){
            list.add(1);
        }
        
        return list;
    }
}