class Solution {
    public int minFlipsMonoIncr(String s) {
        int oneCount = 0;
        int zeroCount = 0;
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            if(ch == '1')
                ++oneCount;
            else
                ++zeroCount;
            zeroCount = Math.min(zeroCount, oneCount);
        }
        return zeroCount;
        
    }
}
