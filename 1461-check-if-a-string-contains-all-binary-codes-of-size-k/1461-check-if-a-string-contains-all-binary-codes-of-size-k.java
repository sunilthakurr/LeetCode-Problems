class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();

        int si = 0;
        int ei = k;

        while (ei <= s.length()) {
            String str = s.substring(si, ei);
            set.add(str);
            si++;
            ei++;
        }
        return set.size() == Math.pow(2, k);
    }
}