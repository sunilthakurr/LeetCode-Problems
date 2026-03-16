class Solution {
    int[] arr={-1,-1,-1};
    void update(int val){
        if(val==arr[0] || val ==arr[1] || val==arr[2]) return;
        if(val>arr[0]){
            arr[2]=arr[1];
            arr[1]=arr[0];
            arr[0]=val;
        }
        else if (val>arr[1]){
            arr[2]=arr[1];
            arr[1]=val;
        }
        else if(val>arr[2]) arr[2]=val;
    
}
    public int[] getBiggestThree(int[][] grid) {
     int rows=grid.length;
     int cols=grid[0].length;
     int max=Math.min(rows,cols);
     for(int size=max;size>=1;size--){
        int s=size-1;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(size ==1) {
                    update(grid[i][j]);
                    continue;
                }
                int left=j-s;
                int right=j+s;
                int bottom=i+2*s;
                if(left < 0 || right >=cols || bottom>=rows) continue;
                int sum=0;
                for(int k=1;k<size;k++)
                sum+= grid[i+k][j+k];
                for(int k=1;k<size;k++) 
                sum+=grid[i+s+k][j+s-k];

                for(int k=1;k<size;k++)
                    sum+=grid[bottom-k][j-k];
                
                for(int k=1;k<size;k++)
                    sum+=grid[i+s-k][left+k];
                
                if(sum >arr[2]) update(sum);
            }
        }
     }   
    int count=0;
    for(int v:arr) if(v !=-1) count++;
    int [] res=new int [count];
    int idx=0;
    for(int v:arr) 
        if(v !=-1) res[idx++] =v;
    return res;
}
}