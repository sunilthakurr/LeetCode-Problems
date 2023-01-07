class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int tc = 0;                           // total cost
        int curr = 0;                         // current fuel
        int si = 0;                           // starting index
        
        for(int i = 0; i < gas.length; ++i){
            
            tc += gas[i] - cost[i];
            curr += gas[i] - cost[i];
            
            if(curr < 0){
                curr = 0;
                si = i + 1;
            }
               
            
        }
        if(tc < 0)
            return -1;
        return si;
    }
  
}
