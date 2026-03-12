class Solution {
    class DSU {

        int[] parent;
        int[] rank;

        DSU(int n){

            parent = new int[n];
            rank = new int[n];

            for(int i=0;i<n;i++)
                parent[i] = i;
        }

        // find with path compression
        int find(int x){
            if(parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        // union by rank
        int unite(int x, int y){

            int px = find(x);
            int py = find(y);

            if(px == py)
                return -1; // cycle detected

            if(rank[px] < rank[py])
                parent[px] = py;
            else if(rank[px] > rank[py])
                parent[py] = px;
            else{
                parent[py] = px;
                rank[px]++;
            }

            return 0;
        }
    }

    public int maxStability(int n, int[][] edges, int k){

        DSU dsu = new DSU(n);

        // min heap for weakest edges
        PriorityQueue<int[]> minpq =
                new PriorityQueue<>((a,b)->a[0]-b[0]);

        // max heap for greedy spanning tree building
        PriorityQueue<int[]> maxpq =
                new PriorityQueue<>((a,b)->b[0]-a[0]);

        int count = 1;

        for(int[] e : edges){

            int u=e[0], v=e[1], score=e[2], must=e[3];

            if(must == 1){

                count++;

                if(dsu.unite(u,v) == -1)
                    return -1;

                minpq.add(new int[]{score,u,v,must});
            }
            else
                maxpq.add(new int[]{score,u,v,must});
        }

        // build spanning tree greedily
        while(count < n && !maxpq.isEmpty()){

            int[] top = maxpq.poll();

            int score=top[0], u=top[1], v=top[2], must=top[3];

            if(dsu.find(u) == dsu.find(v))
                continue;

            dsu.unite(u,v);
            count++;

            minpq.add(new int[]{score,u,v,must});
        }

        if(count != n)
            return -1;

        // perform upgrades
        while(k-- > 0){

            int[] top = minpq.poll();

            int score=top[0], u=top[1], v=top[2], must=top[3];

            if(must == 1)
                return score;

            minpq.add(new int[]{score*2,u,v,1});
        }

        return minpq.peek()[0];
    }
}