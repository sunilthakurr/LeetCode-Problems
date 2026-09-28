class Solution {
    public int maxDepth(String s) {
        return solve(s);
    }

    private int solve(String s) {
        int oCount = 0;
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                ++oCount;
            } else if (ch == ')') {
                --oCount;
            }
            res = Math.max(res, oCount);
        }
        return res;
    }
}