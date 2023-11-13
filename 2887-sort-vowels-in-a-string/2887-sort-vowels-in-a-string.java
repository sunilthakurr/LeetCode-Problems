class Solution {
    public String sortVowels(String s) {
       List<Character> list = new ArrayList<>();
       for(int i = 0; i < s.length(); ++i){
           if(isVowel(s.charAt(i)))
                list.add(s.charAt(i));
        }
        Collections.sort(list);
        System.out.println(list);
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for(int i  = 0; i < s.length(); ++i){
            if(isVowel(s.charAt(i))){
                sb.append(list.get(j++));
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString(); 
    }
    public static boolean isVowel(char ch){
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}