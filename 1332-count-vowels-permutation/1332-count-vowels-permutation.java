class Solution {
    public int countVowelPermutation(int n) {
        long a = 1, e = 1, i = 1, o = 1, u = 1;
        long mod = 1000000007;
        while(n-- > 1){
            long new_a = a % mod, new_e = e % mod, new_i = i % mod, new_o = o % mod, new_u = u % mod;
            a = new_e + new_i + new_u;
            e = new_a + new_i;
            i = new_e + new_o;
            o = new_i;
            u = new_i + new_o;
        }
        return (int)((a+e+i+o+u) % mod);
    }
}