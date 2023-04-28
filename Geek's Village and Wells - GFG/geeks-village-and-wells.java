//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Gfg {
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            
            String s[]=in.readLine().trim().split(" ");
            int n=Integer.parseInt(s[0]);
            int m=Integer.parseInt(s[1]);
            char c[][]=new char[n][m];
            for(int i=0;i<n;i++){
                s=in.readLine().trim().split(" ");
                for(int j=0;j<m;j++){
                    c[i][j]=s[j].charAt(0);
                }
            }
            Solution ob=new Solution();
            int ans[][]=ob.chefAndWells(n, m, c);

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    out.print(ans[i][j]+" ");
                }
                out.println();
            }
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
 class Node{
        int first,second,third;
        public Node(int first,int second,int third){
            this.first=first;
            this.second=second;
            this.third=third;
        }
    }
class Solution
{
    public int[][] chefAndWells(int n,int m,char c[][])
    {
       int[][] vis=new int[n][m];
        int[][] dis=new int[n][m];
        Queue<Node> q=new LinkedList<>();

        //to traverse in four directions from each well
        int[] delrow={-1,0,0,1};
        int[] delcol={0,-1,1,0};

        //storing all wells in the grid and marking them as visited
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(c[i][j]=='W'){
                    q.add(new Node(i,j,0));
                    vis[i][j]=1;
                }
            }
        }


        //BFS
        while(!q.isEmpty()){
            Node node=q.poll();
            int row=node.first;
            int col=node.second;
            int steps=node.third;
            if(c[row][col]=='H'){
                dis[row][col]=2*steps;
            }
            
            for(int i=0;i<4;i++){
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && c[nrow][ncol]!='N'){
                    vis[nrow][ncol]=1;
                    q.add(new Node(nrow,ncol,steps+1));
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && c[i][j]=='H'){
                    dis[i][j]=-1;
                }
            }
        }
        return dis;
    }


}