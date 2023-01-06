class Solution {
    public  int maxIceCream(int[] costs, int coins) {
        int count = 0;
        PriorityQueue<Integer> pr = new PriorityQueue<>();
        for(int i : costs){
            pr.add(i);
        }
        while(coins > 0 && !pr.isEmpty()){
           coins -= pr.poll();
           ++count;
        }
        if(coins < 0)
            return count - 1;
        return count;

    }
}
