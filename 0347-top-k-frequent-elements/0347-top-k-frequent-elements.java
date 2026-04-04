class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();

        for (int el: nums) {
            map.put(el, map.getOrDefault(el, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> b[1] - a[1]);

        for (int key: map.keySet()) {
            int[] arr = new int[2];
            arr[0] = key;
            arr[1] = map.get(key);

            pq.add(arr);
        }

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];
        }
        return res;
    }
}