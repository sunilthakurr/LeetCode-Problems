class Solution {
    public String makeGood(String s) {
        return Good(s);
        
    }
    public static String Good(String s){
        if(s.length() <= 1){
            return s;
        }
        for(int i = 0; i < s.length() - 1; ++i){
            if(Math.abs(s.charAt(i) - s.charAt(i + 1)) == 32){
                return Good(s.substring(0, i) + s.substring(i + 2));
            }
        }
        return s;
        
    }
}