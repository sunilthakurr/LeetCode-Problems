class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        int cnt = 0;
        int[] freq = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                ++cnt;
                if(cnt > 2) return false;
            }
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }
        for(int el: freq) {
            if(el != 0) return false;
        }
        return true;
    }
}