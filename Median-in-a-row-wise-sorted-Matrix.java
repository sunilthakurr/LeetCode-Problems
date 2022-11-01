class Solution {
    int median(int matrix[][], int R, int C) {
        // code here  
        int []res = new int[R * C];
        int x = 0;
        for(int i = 0; i < R; ++i){
            for(int j = 0; j < C; ++j){
                res[x++] = matrix[i][j];
            }
        }
        Arrays.sort(res);
        int mid = R * C / 2;
        return res[mid];
    }
}
