// class Solution {
//     public String stoneGameIII(int[] stoneValue) {
        
//     }
// }

// import java.util.Arrays;

class Solution {
    int[] dp; // Since it tracks relative score difference, we only need a 1D array!

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        dp = new int[n];
        // Initialize with a value that can never be a real score difference
        Arrays.fill(dp, Integer.MIN_VALUE);
        
        // solve() will return: (Current Player's Score) - (Opponent's Score)
        int res = solve(stoneValue, 0);

        if (res == 0) return "Tie";
        if (res > 0) return "Alice"; // Alice (first player) has a positive advantage
        return "Bob";   
    }

    private int solve(int[] arr, int idx) {
        if (idx == arr.length) {
            return 0; // No stones left means 0 score difference can be made
        }
        
        // Memoization check
        if (dp[idx] != Integer.MIN_VALUE) {
            return dp[idx];
        }
        
        int maxDiff = Integer.MIN_VALUE;
        int currentTake = 0;
        
        // Loop through taking 1, 2, or 3 stones legally
        for (int k = 1; k <= 3; k++) {
            if (idx + k <= arr.length) {
                currentTake += arr[idx + k - 1]; // Stones the current player takes
                
                // Current player's score MINUS opponent's optimal future score margin
                int currentDiff = currentTake - solve(arr, idx + k);
                
                maxDiff = Math.max(maxDiff, currentDiff);
            }
        }
        
        dp[idx] = maxDiff; // Cache the maximum relative score possible from this index
        return maxDiff;
    }
}
