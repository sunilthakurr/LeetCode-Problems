class Solution {
    int[][][] container;

    public int maxPathScore(int[][] grid, int k) {
        int c = Math.min(grid.length + grid[0].length, k);
        container = new int[201][201][c + 1];

        for (int[][] cont1 : container) {
            for (int[] cont2 : cont1) {
                Arrays.fill(cont2, -2);
            }
        }

        return memo(grid.length - 1, grid[0].length - 1, 0, k, grid, container);
    }

    private int memo(int row, int col, int cost, int k, int[][] grid, int[][][] container) {
        if (row < 0 || col < 0)
            return -1;

        int totalCost = cost + getCost(grid[row][col]);
        if (totalCost > k) {
            return -1;
        }

        if (container[row][col][totalCost] != -2) {
            return container[row][col][totalCost];
        }
        if (row == 0 && col == 0) {
            return grid[0][0];
        }

        int op1 = memo(row, col - 1, totalCost, k, grid, container);
        int op2 = memo(row - 1, col, totalCost, k, grid, container);

        int maxPrev = Math.max(op1, op2);

        return container[row][col][totalCost] = maxPrev == -1 ? -1 : grid[row][col] + maxPrev;
    }

    private int getCost(int score) {
        return switch (score) {
            case 0 -> 0;
            default -> 1;
        };
    }
}