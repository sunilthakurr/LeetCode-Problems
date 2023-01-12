class Solution {
    // static ArrayList<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        displayParenthesis(n, "", 0, 0, list);
        return list;
    }
    public static void displayParenthesis(int N, String helper, int open, int close, ArrayList<String> list){
//        ArrayList<String> list = new ArrayList<>();
        if(open == N && close == N){
            list.add(helper);
            return;
        }
        if(open < N){
            displayParenthesis(N, helper +"(", open + 1, close, list);
        }
        if(close < open){
            displayParenthesis(N, helper + ")", open , close + 1, list);
        }

    }
}
