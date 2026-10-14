class Solution {
    public String maxSumOfSquares(int num, int sum) {
        return solve(num, sum);
    }
    
    private String solve(int num, int sum) {
        if (num * 9 < sum) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        int cnt = sum / 9;
        for (int i = 0; i < cnt; i++) {
            sb.append("9");
        }
        if (sb.length() < num)
            sb.append((char) ('0' + (sum % 9)));

        while(sb.length() < num) {
            sb.append("0");
        }
        return sb.toString();
    }
}