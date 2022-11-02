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
 
