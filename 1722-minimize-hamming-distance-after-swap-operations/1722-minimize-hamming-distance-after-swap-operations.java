class UnionFind {
    int[] parent;

    UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    boolean unify(int x, int y) {
        int rx = find(x), ry = find(y);
        if (rx == ry) return false;
        if (rx < ry) parent[ry] = rx;
        else parent[rx] = ry;
        return true;
    }
}

class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int N = source.length;
        UnionFind uf = new UnionFind(N);

        for (int[] sw : allowedSwaps)
            uf.unify(sw[0], sw[1]);

        Map<Integer, Map<Integer, Integer>> hm = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int root = uf.find(i);
            hm.computeIfAbsent(root, k -> new HashMap<>())
              .merge(source[i], 1, Integer::sum);
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            int root = uf.find(i);
            Map<Integer, Integer> freq = hm.get(root);
            if (freq != null && freq.getOrDefault(target[i], 0) > 0) {
                res++;
                freq.merge(target[i], -1, Integer::sum);
            }
        }

        return N - res;
    }
}