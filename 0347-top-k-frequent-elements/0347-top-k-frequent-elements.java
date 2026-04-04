class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int el: nums) {
            frequencyMap.put(el, frequencyMap.getOrDefault(el, 0) + 1);
        }

        for (int key: frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);

            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        int[] result = new int[k];

        int idx = 0;

        for (int i = bucket.length - 1; i >= 0 && idx < result.length; i--) {
            if (bucket[i] != null) {
                // System.out.println("hii hello");
                // System.out.println(bucket[i].size());
                for (int j = 0; j < bucket[i].size(); j++) {
                    // System.out.println(bucket[i].get(j));
                    
                    result[idx] = bucket[i].get(j);
                    idx++;
                }
                // result.addAll(bucket[i]);
                // k -= bucket[i].size();
            }
        }
        return result;
    }
}