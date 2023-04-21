//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

public class code1 
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            String s1[]=in.readLine().trim().split(" ");
            String s2[]=in.readLine().trim().split(" ");

            Solution ob=new Solution();
            int ans=ob.prefixSuffixString(s1,s2);
            out.println(ans);

        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    private boolean isPrefix(String s1,String s2){
        if(s1.length()>=s2.length())
            return false;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i))
                return false;
        }
        return true;
    }
    private boolean isSuffix(String s1,String s2){
        if(s1.length()>=s2.length())
            return false;
        for(int i=s1.length()-1;i>=0;i--){
            if(s1.charAt(i)!=s2.charAt(s2.length() - s1.length() + i))
                return false;
        }
        return true;
    }

    public int prefixSuffixString(String s1[],String s2[])
    {
        int cnt=0;
        for(int i=0; i<s2.length;i++) {
            for (String element: s1) {
                if(isSuffix(s2[i],element)||isPrefix(s2[i],element)) {
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }

}