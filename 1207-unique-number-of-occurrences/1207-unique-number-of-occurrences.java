class Solution {
   
        public boolean uniqueOccurrences(int[] arr) {
        int map[]=new int[2001];
        for(int val : arr) map[val+1000]++;
        boolean set[]=new boolean[arr.length+1];
        for(int val : map) 
            if(set[val] && val!=0) return false;
            else set[val]=true;
        return true;
    }
    
}