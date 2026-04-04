class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int vertex = graph.length;

        int[] colors = new int[vertex];
        Arrays.fill(colors, -1);

        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == -1) {
                if (dfs(graph, colors, 0, i) == false) return false;
            }
        }
        return true;
    }

    public boolean dfs(int[][] graph, int[] colors, int col, int node) {
        colors[node] = col;

        for (int vertex: graph[node]) {
            if (colors[vertex] == -1) {
                if (dfs(graph, colors, 1 - col, vertex) == false) return false;
            } else if (colors[vertex] == colors[node]) {
                return false;
            }
        }
        return true;
    }
}