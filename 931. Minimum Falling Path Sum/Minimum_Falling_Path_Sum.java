class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int N = matrix.length;
        int[][] storage = new int[N][N];
        for(int i = 0; i < N; ++i){
            for(int j = 0; j < N; ++j){
                if(i == 0){
                    storage[i][j] = matrix[i][j];
                }
                else if(j == 0){
                    storage[i][j] = Math.min(storage[i - 1][j], storage[i - 1][j + 1]) + matrix[i][j];
                }
                else if(j == N - 1){
                    storage[i][j] = Math.min(storage[i - 1][j], storage[i - 1][j - 1]) + matrix[i][j];
                }
                else{
                    storage[i][j] = Math.min(storage[i - 1][j], Math.min(storage[i - 1][j - 1], storage[i - 1][j + 1])) + matrix[i][j];
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < N; ++i){
            result = Math.min(result, storage[N - 1][i]);
        }
        return result;
    }
}
