class Solution {
    public int maxDepth(String s) {
        return solve(s);
    }
    private int solve(String str) {

        int cnt = 0;
        int res = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                ++cnt;
            } if (ch == ')') {
                --cnt;
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
}