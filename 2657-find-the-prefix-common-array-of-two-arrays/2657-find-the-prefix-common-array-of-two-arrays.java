class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;

        int[] res = new int[n];

        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            map1.put(A[i], map1.getOrDefault(A[i], 0) + 1);
            map2.put(B[i], map2.getOrDefault(B[i], 0) + 1);

            if (A[i] == B[i]) {
                cnt += 1;
            } else {
                cnt += Math.min(map1.getOrDefault(A[i], 0), map2.getOrDefault(A[i], 0));
                cnt += Math.min(map1.getOrDefault(B[i], 0), map2.getOrDefault(B[i], 0));
            }
            res[i] = cnt;
        }
        return res;
    }
}