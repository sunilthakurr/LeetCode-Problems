class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for(int el: nums) {
            pq.add((long)el);
        }
        return solve(pq, k);
    }
    public static int solve(PriorityQueue<Long> pq, long k) {
	    int cnt = 0;
	    
	    while(pq.size() >= 2) {
	        long first = pq.poll();
	        long second = pq.poll();
	        if(first >= k) {
	            break;
	        }
	        long val = Math.min(first, second) * 2 + Math.max(first, second);
	        cnt++;
	        pq.add(val);
	    }
	    return cnt;
	}
}