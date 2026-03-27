class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat[0].length;
        k = k%n;
        boolean firstRowSatisfied = true;
        for(int i=0;i<n;i++){
            if(mat[0][i] == mat[0][(i+k)%n]) continue;
            else{
                firstRowSatisfied = false;
                break;
            }
        }
        if(mat.length==1) return firstRowSatisfied;
        if(firstRowSatisfied == false) return firstRowSatisfied;
        boolean secondRowSatisfied = true;
        for(int i=0;i<n;i++){
            if(mat[1][i] == mat[1][(i+n-k)%n]) continue;
            else{
                secondRowSatisfied = false;
                break;
            }
        }
    return secondRowSatisfied;
    }
}