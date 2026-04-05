class Solution {
    public boolean judgeCircle(String moves) {
        return NarutoGatoProblem(moves);
    }
    public static boolean NarutoGatoProblem(String moves){
        int r = 0;
        int c = 0;
        for( int i = 0 ; i<moves.length() ; i++){
            char ch = moves.charAt(i);
            if(ch=='U') r += 1;
            else if(ch=='D') r -= 1;
            else if(ch=='L') c += 1;
            else c -= 1;
        }   
       return r == 0 && c == 0;

}
}