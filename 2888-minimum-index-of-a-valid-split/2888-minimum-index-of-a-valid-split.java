class Solution {
    public int minimumIndex(List<Integer> nums) {
        int dominant = -1;
        int count = 0;
        for(int el: nums) {
            if(count == 0) {
                dominant = el;
            }
            if(el == dominant) {
                ++count;
            }
            else {
                --count;
            }
        }
        count = 0;
        for(int el: nums) {
            if(el == dominant) ++count;
        }
        int cnt = 0;
        for(int i = 0; i < nums.size(); i++) {
            if(nums.get(i) == dominant) ++cnt;
            if((cnt > (i + 1) / 2) && (count - cnt) > (nums.size() - i - 1) / 2)
                return i;
        }
        return -1;
    }
}