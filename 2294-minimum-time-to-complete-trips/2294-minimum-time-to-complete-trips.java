class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long low=1;
        long high=Long.MAX_VALUE-100000;
        long ans=high;
        while(low<=high)
        {
            long mid=(low+high)/2;
            if(valid(time,mid,totalTrips))
            {
                ans=Math.min(ans,mid);
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return ans;

    }
    public boolean valid(int[]time,long t,long totalTrips)
    {
        long temp=0;
      for(int x:time)
      {
          temp+=(t/x);
          if(temp>=totalTrips)
          return true;
      }
      return temp>=totalTrips;


    }
}