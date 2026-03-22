class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        if (isBothMatrixEqual(mat, target)) {
            return true;
        }
        for (int ind = 0; ind <= n; ind++) {
            int[][] brr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    brr[i][j] = mat[n - 1 - j][i];
                }
            }
            if (isBothMatrixEqual(brr, target)) {
                return true;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = brr[i][j];
                }
            }
        }
        return false;
    }
    private boolean isBothMatrixEqual(int[][] arr, int[][] brr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != brr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}