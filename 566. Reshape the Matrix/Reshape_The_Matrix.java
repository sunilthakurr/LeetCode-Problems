class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length * mat[0].length != r * c){
            return mat;
        }
        int flag = 0;
        int[] temp = new int[mat.length * mat[0].length];
        for(int i = 0; i < mat.length; ++i){
            for(int j = 0; j < mat[0].length; ++j){
                temp[flag++] = mat[i][j];
            }
        }
        int counter = 0;
        // System.out.println(r * c +" "+flag);
        int[][] arr2 = new int[r][c];
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                arr2[i][j] = temp[counter++];
            }
        }
        return arr2;
    }
}
