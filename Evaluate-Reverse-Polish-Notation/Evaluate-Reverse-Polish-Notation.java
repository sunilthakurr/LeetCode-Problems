class Solution {
    public int evalRPN(String[] tokens) {
        // int a, int b;
        Stack<Integer> st = new Stack<Integer>();
        
        for(int i = 0; i < tokens.length; ++i){
            if(tokens[i].equals("+")){
                st.push(st.pop() + st.pop());
            }
            else if(tokens[i].equals("-")){

                st.push(-st.pop() + st.pop());
            }
            else if(tokens[i].equals("*")){
                st.push(st.pop() * st.pop());
            }
            else if(tokens[i].equals("/")){
                int temp = st.pop();
                st.push(st.pop() / temp);
            }
            else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.pop();
        
    }
}
