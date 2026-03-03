class Solution {
    public char findKthBit(int n, int k) {

        StringBuilder sb = new StringBuilder();
        sb.append("0");

        for (int i = 2; i <= n; i++) {
            // sb = sb.append("1");
            String inversed = invert(sb.toString());
            String reversed = reverse(inversed);
            // System.out.println("original :- "+ sb.toString() + " inversed :- "+inversed+" reversed :- "+reversed);
            // StringBuilder str = reverse(invert(sb.toString()).toString());
            sb.append("1");
            sb.append(reversed);
        }
        // System.out.println(sb.toString());
        return sb.charAt(k - 1);
    }
    private String reverse(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
    private String invert(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if (ch == '0') {
                sb.insert(i, '1');
            } else {
                sb.insert(i, '0');
            }
        }
        return sb.toString();
    }
}