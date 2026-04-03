import java.util.*;

class Solution {
    public int maxWalls(int[] robots, int[] dist, int[] walls) {
        int n = robots.length;

        int[][] detail = new int[n][2];
        for (int i = 0; i < n; i++) {
            detail[i][0] = robots[i];
            detail[i][1] = dist[i];
        }

        Arrays.sort(detail, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(walls);

        // count walls in range [left, right]
        java.util.function.BiFunction<Integer, Integer, Integer> cntWalls = (left, right) -> {
            if (left > right) return 0;
            int l = lowerBound(walls, left);
            int r = upperBound(walls, right);
            return r - l;
        };

        int resWalls = 0;
        for (int i = 0; i < n; i++) {
            if (Arrays.binarySearch(walls, detail[i][0]) >= 0) {
                resWalls++;
            }
        }

        int[][] dp = new int[n][2];

        dp[0][0] = cntWalls.apply(detail[0][0] - detail[0][1], detail[0][0] - 1);
        dp[0][1] = 0;

        for (int i = 1; i < n; i++) {
            int prevpos = detail[i - 1][0];
            int currpos = detail[i][0];

            int gapWalls = cntWalls.apply(prevpos + 1, currpos - 1);
            int leftRange = cntWalls.apply(Math.max(prevpos + 1, currpos - detail[i][1]), currpos - 1);
            int rightRange = cntWalls.apply(prevpos + 1, Math.min(currpos - 1, prevpos + detail[i - 1][1]));

            int extraWall;
            if (prevpos + detail[i - 1][1] >= currpos - detail[i][1]) {
                extraWall = gapWalls;
            } else {
                extraWall = leftRange + rightRange;
            }

            dp[i][0] = Math.max(dp[i - 1][0] + leftRange, dp[i - 1][1] + extraWall);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + rightRange);
        }

        int lastRight = cntWalls.apply(
                detail[n - 1][0] + 1,
                detail[n - 1][0] + detail[n - 1][1]
        );

        return resWalls + Math.max(dp[n - 1][0], dp[n - 1][1] + lastRight);
    }

    private int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] <= target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}