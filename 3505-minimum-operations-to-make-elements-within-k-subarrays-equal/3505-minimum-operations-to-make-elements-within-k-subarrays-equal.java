import java.util.TreeMap;
class Solution {
    private final long INF = 1_000_000_000_000_000L;
    long[][] memo;
    public long minOperations(int[] nums, int x, int k) {
        long[] cost = minOpsForSubarraysOfSizeK(nums, x);
        memo = new long[nums.length + 1][k + 1];
        for (int i = 0; i <= nums.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        // System.out.println(Arrays.toString(cost));

        return solve(nums, 0, x, k, 0, cost);
    }

    private long solve(int[] nums, int si, int x, int k, int cnt, long[] cost) {
        if (cnt == k) {
            return 0;
        }
        if (si + x > nums.length && cnt != k) {
            return INF; // not possible
        }
        if (memo[si][cnt] != -1) {
            return memo[si][cnt];
        }
        // select
        long op1 = cost[si] + solve(nums, si + x, x, k, cnt + 1, cost);

        // no select
        long op2 = solve(nums, si + 1, x, k, cnt, cost);
        return memo[si][cnt] = Math.min(op1, op2);
    }

    public static long[] minOpsForSubarraysOfSizeK(int[] arr, int k) {
        if (arr == null || k <= 0 || k > arr.length)
            return new long[0];

        int n = arr.length;
        long[] result = new long[n - k + 1];

        // Two TreeMaps to track frequencies in the lower and upper halves
        TreeMap<Integer, Integer> leftMax = new TreeMap<>();
        TreeMap<Integer, Integer> rightMin = new TreeMap<>();

        int leftSize = 0, rightSize = 0;
        long leftSum = 0, rightSum = 0;
        int targetLeftSize = (k + 1) / 2;

        for (int i = 0; i < n; i++) {
            // 1. Add current element
            int num = arr[i];
            if (leftSize == 0 || num <= leftMax.lastKey()) {
                leftMax.put(num, leftMax.getOrDefault(num, 0) + 1);
                leftSum += num;
                leftSize++;
            } else {
                rightMin.put(num, rightMin.getOrDefault(num, 0) + 1);
                rightSum += num;
                rightSize++;
            }

            // 2. Remove element sliding out of window
            if (i >= k) {
                int out = arr[i - k];
                if (leftSize > 0 && out <= leftMax.lastKey()) {
                    if (leftMax.put(out, leftMax.get(out) - 1) == 1)
                        leftMax.remove(out);
                    leftSum -= out;
                    leftSize--;
                } else {
                    if (rightMin.put(out, rightMin.get(out) - 1) == 1)
                        rightMin.remove(out);
                    rightSum -= out;
                    rightSize--;
                }
            }

            // 3. Balance maps
            while (leftSize > targetLeftSize) {
                int val = leftMax.lastKey();
                if (leftMax.put(val, leftMax.get(val) - 1) == 1)
                    leftMax.remove(val);
                leftSum -= val;
                leftSize--;
                rightMin.put(val, rightMin.getOrDefault(val, 0) + 1);
                rightSum += val;
                rightSize++;
            }
            while (leftSize < targetLeftSize && rightSize > 0) {
                int val = rightMin.firstKey();
                if (rightMin.put(val, rightMin.get(val) - 1) == 1)
                    rightMin.remove(val);
                rightSum -= val;
                rightSize--;
                leftMax.put(val, leftMax.getOrDefault(val, 0) + 1);
                leftSum += val;
                leftSize++;
            }

            // 4. Calculate operations for valid window
            if (i >= k - 1) {
                long median = leftMax.lastKey();
                result[i - k + 1] = (rightSum - rightSize * median) + (leftSize * median - leftSum);
            }
        }
        return result;
    }
}