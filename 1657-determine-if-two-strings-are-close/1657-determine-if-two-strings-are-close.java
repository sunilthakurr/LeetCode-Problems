class Solution {
    public boolean closeStrings(String word1, String word2) {
     char[]c1= new char[26];
     char[]c2= new char[26];
    //  if(word1.length()!=word2.length()){
    //      return false;
    //  }
     for(char c:word1.toCharArray()){
         c1[c-'a']++;
     }  
     for(char c:word2.toCharArray()){
         c2[c-'a']++;
     }
     for (int i = 0; i < c1.length; i++) {
            if (c1[i] == c2[i]) {
                continue;
            }
            if (c1[i] == 0 || c2[i] == 0) {
                return false;
            }
        }
    Arrays.sort(c1);
    Arrays.sort(c2);
    for(int i=0; i<c1.length; i++){
        if(c1[i]!=c2[i]) return false;
    }
return true;
    }
}