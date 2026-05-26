class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            set.add(word.charAt(i));
        }

        int cnt = 0;
        System.out.println(set.toString());
        for (int i = 0; i < 26; i++) {
            if (set.contains((char)('a' + i)) && set.contains((char)( 'A' + i))) {
                ++cnt;
            }
        }
        return cnt;
    }
}