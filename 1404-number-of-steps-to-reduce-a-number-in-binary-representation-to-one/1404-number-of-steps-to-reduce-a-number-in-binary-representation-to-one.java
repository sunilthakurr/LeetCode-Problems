class Solution {
    public int numSteps(String s) {
        int cnt = 0;

        while (s.length() != 1) {
            char ch = s.charAt(s.length() - 1);

            if (ch == '0') {
                s = s.substring(0, s.length() - 1);
            } else {
                s = recreate(s);
            }
            ++cnt;
        }
        return cnt;
    }
    private String recreate(String str) {
        StringBuilder sb = new StringBuilder(str);
        int size = sb.length();

        int idx = size - 1;
        while(idx >= 0) {
            char ch = sb.charAt(idx);

            if (ch == '0') {
                sb.setCharAt(idx, '1');
                return sb.toString();
            } else {
                sb.setCharAt(idx, '0');
            }
            idx--;
        }
        return "1" + sb.toString();
    }
}