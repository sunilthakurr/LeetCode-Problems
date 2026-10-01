class Solution {
    public boolean isValid(String s) {
        return solve(s);
    }

    private boolean solve(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                st.add(ch);
            } else {
                if (st.isEmpty()) return false;
                if (st.peek() == '(' && ch == ')' || (st.peek() == '{' && ch == '}') 
                || (st.peek() == '[' && ch == ']')) {
                    st.pop();
                    continue;
                } else {
                    return false;
                }
            }
        }
        if (!st.isEmpty()) {
            return false;
        }
        return true;
    }
}