class Solution {
    public boolean canBeEqual(String s1, String s2) {
        return solve(s1, s2);
    }
    private boolean solve(String s1, String s2) {

        char ch1 = s1.charAt(0);
        char ch11 = s2.charAt(0);

        char ch2 = s1.charAt(2);
        char ch22 = s2.charAt(2);

        boolean isFirstTrue = ((ch1 == ch11) && (ch2 == ch22)) || ((ch1 == ch22) && (ch2 == ch11));

        ch1 = s1.charAt(1);
        ch11 = s2.charAt(1);

        ch2 = s1.charAt(3);
        ch22 = s2.charAt(3);
        
        boolean isSecondTrue = ((ch1 == ch11) && (ch2 == ch22)) || ((ch1 == ch22) && (ch2 == ch11));

        return isFirstTrue && isSecondTrue;
    }
}