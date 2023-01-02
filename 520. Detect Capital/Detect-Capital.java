class Solution {
    public boolean detectCapitalUse(String word) {
        return isValid(word);
    }
    public static boolean isValid(String str){
        int len = str.length();
        if(len <= 1)
            return true;
        boolean fchar = isSmall(str.charAt(0));
        if(fchar){
            for(int i = 1; i < len; ++i){
                if(!isSmall(str.charAt(i))){
                    return false;
                }
            }
            return true;
        }
        else{
            boolean schar = isSmall(str.charAt(1));
            if(!schar){
                for(int i = 2; i < len; ++i){
                    if(!isCapital(str.charAt(i)))
                        return false;
                }
                
                return true;
            }
            else {
                for(int i = 2; i < len; ++i){
                    if(!isSmall(str.charAt(i)))
                        return false;
                }
                return true;
            }
        }
    }
    public static boolean isSmall(char ch){
        if(ch >= 97 && ch <= 122)
            return true;
        return false;
    }
    public static boolean isCapital(char ch){
        if(ch >= 65 && ch <= 90)
            return true;
        return false;
    }
}
