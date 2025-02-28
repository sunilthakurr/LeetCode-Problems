class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        String str = lcs(str1, str2);
        System.out.println(str);
        StringBuilder sb = new StringBuilder();
        int n = str1.length();
        int m = str2.length();

        int i = 0, j = 0, x = 0;

        while(x < str.length() && i < str1.length() && j < str2.length()) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(j);
            char ch = str.charAt(x);

            if(ch1 == ch2 && ch1 == ch) {
                sb.append(ch1);
                ++i;
                ++j;
                ++x;
                continue;
            }
            while(i < n && str1.charAt(i) != ch) {
                sb.append(str1.charAt(i));
                ++i;
                // ch1 = str1.charAt(i);
            }
            while(j < m && str2.charAt(j) != ch) {
                sb.append(str2.charAt(j));
                ++j;
                // ch2 = str2.charAt(j);
            }
            
        }
        while(i < str1.length()) {
            sb.append(str1.charAt(i));
            ++i;
        }
        while(j < str2.length()) {
            sb.append(str2.charAt(j));
            ++j;
        }
       

        return sb.toString();
    }
    // return LCS
    public String lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= m; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        
        StringBuilder sb = new StringBuilder();

        int i = n;
        int j = m;

        while(i > 0 && j > 0) {
            if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                --i;
                --j;
            }
            else if(dp[i - 1][j] >= dp[i][j - 1])
                i -= 1;
            else
                j -= 1;
            
        }
        return sb.reverse().toString();
    }
}