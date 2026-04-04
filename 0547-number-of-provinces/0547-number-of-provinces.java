class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        Set<Integer> vis = new HashSet<>();
        int res = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (!vis.contains(i)) {
                res++;
                bfs(isConnected, vis, i);
            }
        }
        return res;
    }

    private void bfs(int[][] isConnected, Set<Integer> vis, int vertex) {

        Queue<Integer> q = new LinkedList<>();

        q.add(vertex);
        vis.add(vertex);

        while (!q.isEmpty()) {

            int el = q.poll();
            // vis.add(el);

            for (int i = 0; i < isConnected.length; i++) {
                if (isConnected[el][i] == 1 && !vis.contains(i)) {
                    q.add(i);
                    vis.add(i);
                }
            }
        }
    }
}