class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int x1 = x;
        int y1 = y;

        int x2 = x + k - 1;
        int y2 = y + k - 1;

        while (x1 < x2) {
            for (int i = y1; i <= y2; i++) {
                int temp = grid[x1][i];
                grid[x1][i] = grid[x2][i];
                grid[x2][i] = temp;
            }
            ++x1;
            --x2;
        }
        return grid;
    }
}