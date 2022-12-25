class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int sum = 0;
        int len = nums.length;
        for(int i = 0; i < len; ++i){
            sum += nums[i];
        }
        int temp = sum;
        int len2 = queries.length;
        Arrays.sort(nums);
        for(int i = 0; i < len2; ++i){
            if(sum <= queries[i]){
                queries[i] = len;
            }
            else{
                int j = len - 1;
                while(sum > queries[i] && j >= 0){
                    sum -= nums[j];
                    --j;
                }
                queries[i] = j + 1;
            }
            sum = temp;
        }
        return queries;
    }
}
