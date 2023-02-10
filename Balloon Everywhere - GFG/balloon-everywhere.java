//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.maxInstance(s);
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxInstance(String s) {
        // Code here
        return maxBallonPossible(s);
    }
    public static int maxBallonPossible(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : str.toCharArray()){
            if(!map.containsKey(ch)){
                map.put(ch, 1);
            }
            else{
                map.put(ch, map.get(ch) + 1);
            }
        }
        int[] arr = new int[5];
        arr[0] = map.get('l') / 2;
        arr[1] = map.get('b');
        arr[2] = map.get('a');
        arr[3] = map.get('o') / 2;
        arr[4] = map.get('n');
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 5; ++i){
            min = Math.min(min, arr[i]);
        }
        return min;
    }
}