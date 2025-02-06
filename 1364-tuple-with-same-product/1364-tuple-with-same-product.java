class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                int val = nums[i] * nums[j];
                map.put(val, map.getOrDefault(val, 0) + 1);
            }
        }
        int res = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int val = entry.getValue();
            System.out.println(entry.getKey()+" -> "+entry.getValue());
            if(val > 1) {
                res += (((val - 1) * (val)) / 2) * 8;
            }
        }
        return res;
    }
    public int notation(int n) {
        int res = 1;
        for(int i = 1; i < n; i++) {
            res *= i;
        }
        return res;
    }
}