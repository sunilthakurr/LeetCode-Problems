class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        char[] arr = s.toCharArray();
        
        for(int i = 0; i < arr.length; ++i){
            if(!st.isEmpty() && st.peek() == arr[i]){
                st.pop();
            }
            else{
                st.push(arr[i]);
            }
        }
        String str = "";
        while(!st.isEmpty()){
            str = st.pop() + str;
        }
        return str;
    }
}