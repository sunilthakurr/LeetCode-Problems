class Solution {
    public boolean halvesAreAlike(String s) {
        int len = s.length();
        String s1 = s.substring(0, len/2);
        String s2 = s.substring(len / 2);
        int l1 = vowelCount(s1);
        int l2 = vowelCount(s2);
        // System.out.println(s1+" "+s2);
        // System.out.println(l1+" "+l2);
        if(l1 == l2)
            return true;
        return false;
    }
    public static int vowelCount(String str){
        if(str.length() == 0)
            return 0;
        if(str.charAt(0) == 'a' || str.charAt(0) == 'e' || str.charAt(0) == 'i' || str.charAt(0) == 'o' || str.charAt(0) == 'u' || str.charAt(0) == 'A' || str.charAt(0) == 'E' || str.charAt(0) == 'I' || str.charAt(0) == 'O' || str.charAt(0) == 'U')
            return vowelCount(str.substring(1)) + 1;
        else
            return vowelCount(str.substring(1));
    }
}