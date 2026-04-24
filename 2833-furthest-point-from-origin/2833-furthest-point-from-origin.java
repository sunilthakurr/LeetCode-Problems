class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int lCount = 0, rCount = 0, _count = 0;

        for (int i = 0; i < moves.length(); i++) {
            char ch = moves.charAt(i);

            switch (ch) {
                case 'R' -> ++rCount;
                case 'L' -> ++lCount;
                default -> ++_count;
            }
        }
        return Math.abs(lCount - rCount) + _count;
    }
}