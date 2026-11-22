class Solution {
    public boolean checkString(String s) {
        return solve(s);
    }

    private boolean solve(String s) {
        int bCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == 'a') {
                if (bCount != 0) {
                    return false;
                }
            } else {
                bCount += 1;
            }
        }
        return true;
    }
}