class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};

        dfs(sr, sc, color, image, image[sr][sc], drow, dcol);
        return image;
    }
    private void dfs(int row, int col, int color, int[][] image, int sourceColor, int[] drow, int[] dcol) {

        image[row][col] = color;

        for (int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if (nrow >= 0 && nrow < image.length && ncol >= 0 && ncol < image[0].length &&
                image[nrow][ncol] == sourceColor && image[nrow][ncol] != color) {
                    dfs(nrow, ncol, color, image, sourceColor, drow, dcol);
                }
        }
    }
}