class Solution {
    public int countSubstrings(String s) {
        return Strin(s) + s.length();
        
    }
    public static int Strin(String s){
        int count = 0;
        for(int i = 0; i < s.length(); ++i){
            for(int j = i + 1; j < s.length(); ++j){
                String st = s.substring(i, j +1);
                // System.out.print(st+" ");
                if(isPallandrome(st))
                    ++count;
            }
        }
        return count;
    }
    public static boolean isPallandrome(String str){
        int len = str.length();
        if(len == 1)
            return true;
        int j = len - 1;
        for(int i = 0; i <= len/2; ++i){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            
            }
            --j;
        }
        return true;
    }
}