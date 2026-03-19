class Solution {
    class Pair {
        int xCount;
        int yCount;

        public Pair(int xCount, int yCount) {
            this.xCount = xCount;
            this.yCount = yCount;
        }
    }
    public int numberOfSubmatrices(char[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;

        Pair[][] arr = new Pair[row + 1][col + 1];

        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= col; j++) {
                arr[i][j] = new Pair(0, 0);
            }
        }

        int cnt = 0;

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                char ch = grid[i - 1][j - 1];

                int curX = ch == 'X' ? 1 : 0;
                int curY = ch == 'Y' ? 1 : 0;

                int xCount = curX + arr[i - 1][j].xCount + arr[i][j - 1].xCount - arr[i - 1][j - 1].xCount;
                int yCount = curY + arr[i - 1][j].yCount + arr[i][j - 1].yCount - arr[i - 1][j - 1].yCount;

                arr[i][j] = new Pair(xCount, yCount);

                if (xCount == yCount && xCount > 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}