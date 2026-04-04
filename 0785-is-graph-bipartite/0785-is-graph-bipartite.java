class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int row = graph.length;
        int col = graph[0].length;

        // -1 -> not visited, 0 --> red, 1 --> green
        int[] color = new int[row];
        Arrays.fill(color, -1);

        for (int i = 0; i < row; i++) {
            if (color[i] == -1) {
                if (dfs(i, 0, color, graph) == false) return false;
            }
        }
        return true;
    }
    
    private boolean dfs(int node, int col, int[] color, int[][] graph) {
        color[node] = col;

        for (int i : graph[node]) {
            if (color[i] == -1) {
                if (dfs(i, 1 - col, color, graph) == false) return false; 
            } else if (color[i] == color[node]) return false;
        }
        return true;
    }
}