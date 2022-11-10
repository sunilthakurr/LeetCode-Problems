class Solution {
    public int removeDuplicates(int[] nums) {
        int temp = 1;
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] != nums[i - 1]){
                ++temp;
            }
        }
        Stack<Integer> q = new Stack<>();
        q.push(nums[0]);
        int count = 1;
        for(int i = 0; i < nums.length; ++i){
            if(q.peek() != nums[i]) {
                q.push(nums[i]);
                ++count;
            }

        }
        for(int i = count - 1; i >= 0; --i){
            nums[i] = q.pop();
        }
        // System.out.println(Arrays.toString(nums));
        return temp;
        
    }
}