class Solution {
    public int trap(int[] height) {
        
        int n = height.length;

        if (n <= 2) return 0;

        int[] leftMaximum = new int[n];
        int[] rightMaximum = new int[n];

        for (int i = 1; i < n; i++) {
            leftMaximum[i] = Math.max(leftMaximum[i - 1], height[i - 1]);
        }

        for (int i = n - 2; i >= 0; i--) {
            rightMaximum[i] = Math.max(rightMaximum[i + 1], height[i + 1]);
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            if (leftMaximum[i] > height[i] && rightMaximum[i] > height[i]) {
                // int boundaryLength = Math.min(leftMaximum[i], rightMaximum[i]);
                
                res += Math.min(leftMaximum[i], rightMaximum[i]) - height[i];
            }
        }
        return res;
    }
}