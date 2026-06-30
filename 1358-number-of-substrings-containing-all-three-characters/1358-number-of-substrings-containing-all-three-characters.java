class Solution {
    public int numberOfSubstrings(String s) {
        int[] arr = new int[3];

        int cnt = 0;
        int si = 0;
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;

            while (arr[0] > 0 && arr[1] > 0 && arr[2] > 0) {
                cnt += s.length() - i;
                arr[s.charAt(si) - 'a']--;
                si++;
            }
        }
        return cnt;
    }
}