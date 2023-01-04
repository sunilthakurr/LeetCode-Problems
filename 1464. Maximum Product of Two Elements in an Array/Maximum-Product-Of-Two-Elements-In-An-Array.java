class Solution {
    public int maxProduct(int[] nums) {
        return maxP(nums);
    }
    public static int maxP(int[] arr){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : arr){
            pq.add(i);
        }
        int num = pq.poll() - 1;
        num *= pq.poll() - 1;
        return num;
    }
}
