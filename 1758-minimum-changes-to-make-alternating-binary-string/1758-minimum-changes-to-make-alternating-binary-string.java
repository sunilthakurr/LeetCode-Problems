class Solution {
    public int minOperations(String s) {
        int op1 = 0, op2 = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if ((i % 2 == 0 && ch == '1') || (i % 2 != 0 && ch == '0')) {
                ++op1;
            }
            if ((i % 2 == 0 && ch == '0') || (i % 2 != 0 && ch == '1')) {
                ++op2;
            }
        }
        return Math.min(op1, op2);
    }
}