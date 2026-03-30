class Solution {
    public boolean checkStrings(String s1, String s2) {
        return solve(s1, s2);
    }
    private boolean solve(String str1, String str2) {
        int[] arr = new int[26];
        int[] brr = new int[26];


        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);

            if (i % 2 == 0) {
                arr[ch - 'a']++;
            } else {
                brr[ch - 'a']++;
            }
        }

        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);

            if (i % 2 == 0) {
                if (arr[ch - 'a'] == 0) {
                    return false;
                }
                arr[ch - 'a']--;
            } else {
                if (brr[ch - 'a'] == 0) {
                    return false;
                }
                brr[ch - 'a']--;
            }
        }
        return true;
    }
}