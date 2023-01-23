//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.removePair(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String removePair(String s) {
        // code here
        String str = String.valueOf(helper(s));
        if(str.length() == 0)
            return "-1";
        return str;
    }
    public static StringBuilder helper(String str){
        Stack<Character> st = new Stack<>();
        st.push(str.charAt(0));
        for(int i = 1; i < str.length(); ++i){
            if(!st.isEmpty() && st.peek() == str.charAt(i) ){
                st.pop();

            }
            else
                st.push(str.charAt(i));
        }
        String s = "";
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
           sb.append(st.pop());
        }
        return sb.reverse();
    }
}
        
