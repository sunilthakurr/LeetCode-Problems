class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int V = graph.length;

        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        boolean[] safeStates = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(graph, vis, pathVis, safeStates, i);
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (safeStates[i]) {
                list.add(i);
            }
        }
        return list;
    }

    private boolean dfs(int[][] graph, boolean[] vis, boolean[] pathVis, boolean[] safeStates, int node) {

        vis[node] = true;
        pathVis[node] = true;

        for (int vertex: graph[node]) {
            if (!vis[vertex]) {
                if (dfs(graph, vis, pathVis, safeStates, vertex)) {
                    return true;
                }
            } else if (pathVis[vertex]) {
                return true;
            }
        }

        safeStates[node] = true;
        pathVis[node] = false;
        return false;
    }
}