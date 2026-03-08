class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;

        int lb = 0;
        int ub = (int)Math.pow(2, n + 1) - 1;

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            int val = solve(nums[i]);
            set.add(val);
        }
        for(int i = lb; i <= ub; i++) {
            if(!set.contains(i)) {
                String res = decToBinary(i);
                res = res.substring(res.length() - n);
                return res;
            }
        }
        return "1";
    }
    public int solve(String num) {
        int res = 0;
        int j = 0;
        for(int i = num.length() - 1; i >= 0; i--) {
            if(num.charAt(i) == '1') {
                res += (int)Math.pow(2, j);
            }
            ++j;
        }
        return res;
    }

    public String decToBinary(int n)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            int k = n >> i;
            if ((k & 1) > 0)
                sb.append("1");
            else
                sb.append("0");
        }
        return sb.toString();
    }
}