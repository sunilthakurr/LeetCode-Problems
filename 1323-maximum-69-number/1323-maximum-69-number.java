class Solution {
    public int maximum69Number (int num) {
        String str = String.valueOf(num);
        
        
        int index = -1;
        for(int i = 0; i < str.length(); ++i){
            if(str.charAt(i) == '6'){
                index = i;
                break;
            }
        }
        if(index != -1)
             str = str.substring(0, index) + '9' + str.substring(index + 1);
        return Integer.parseInt(str);
    }
}