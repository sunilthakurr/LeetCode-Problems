class Solution {
    public int maxPoints(int[][] points) {
        int ans = 0;
        for (int i = 0; i<points.length; ++i){
            Map<Double, Integer> check = new HashMap<>();
            for (int  j = i+1; j<points.length; ++j){
                double slope;
                if (points[i][0] == points[j][0])
                    slope = Double.MAX_VALUE;
                else{
                    slope = (points[i][1] - points[j][1]) / ((double) (points[i][0] - points[j][0]));
                    if (slope == -0.0)
                        slope = 0.0;
                }
                check.put(slope, check.getOrDefault(slope, 0) + 1);
                ans = Math.max(ans, check.get(slope));
            }
        }
        return ans+1;
    }
}
