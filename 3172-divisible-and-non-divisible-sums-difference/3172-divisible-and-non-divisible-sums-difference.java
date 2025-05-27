class Solution {
    public int differenceOfSums(int n, int m) {
        int sum = (n * (n + 1)) / 2;
        int a = m;
        int d = m;
        int cnt = n / d;

        int num2 = (cnt * ((2 * a) + (cnt - 1) * d)) / 2;

        return sum - 2 * num2;
    }
}