class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        return result(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
    }
    public int result(int A, int B, int C, int D, int E, int F, int G, int H) {
    int sum = (C-A)*(D-B) + (G-E)*(H-F);
    if(C<=E||A>=G||B>=H||D<=F)
        return sum;
    int comm = (Math.min(C,G)-Math.max(A,E))*(Math.min(D,H)-Math.max(B,F));
    return sum-comm;

}
}