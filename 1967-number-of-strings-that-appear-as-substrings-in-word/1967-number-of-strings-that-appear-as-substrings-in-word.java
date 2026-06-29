class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int cnt = 0;

        for (String str: patterns) {
            if (word.contains(str)) {
                cnt += 1;
            }
        }
        return cnt;
    }
}