class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");
        if (str.length != pattern.length())
            return false;
        HashMap<Character, String> map = new HashMap<>();


        for (int i = 0; i < pattern.length(); ++i) {
            char ch = pattern.charAt(i);
            boolean iskeyPresent = map.containsKey(ch);
            if(map.containsValue(str[i]) && !iskeyPresent)
                return false;
            if(iskeyPresent && !map.get(ch).equals(str[i]))
                return false;
            else
                map.put(ch, str[i]);
        }
        return true;
    }
}
