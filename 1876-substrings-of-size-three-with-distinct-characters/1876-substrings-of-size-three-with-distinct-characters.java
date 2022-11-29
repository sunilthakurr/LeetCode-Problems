class Solution {
    public int countGoodSubstrings(String s) {
        if(s.length() < 3)
            return 0;
        char c1 = s.charAt(0);
        char c2 = s.charAt(1);
        char c3 = s.charAt(2);
        int count = 0;
        if(c1 != c2 && c2 != c3 && c1 != c3)
            ++count;
        return countGoodSubstrings(s.substring(1)) + count;
    }
    
}