class StockSpanner {

    private Stack<Pair<Integer,Integer>> st;
    
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        
        while(!st.empty() && st.peek().getKey() <= price){
            span +=st.pop().getValue();
        }
        st.push(new Pair(price,span));
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */