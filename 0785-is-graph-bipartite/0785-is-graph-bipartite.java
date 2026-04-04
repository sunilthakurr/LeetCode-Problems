class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int vertices = graph.length;

        int[] colors = new int[vertices];
        Arrays.fill(colors, -1);

        for (int i = 0; i < vertices; i++) {
            if (colors[i] == -1) {
                if(bfs(graph, colors, 0, i) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfs(int[][] graph, int[] colors, int col, int vertex) {
        
        Queue<Integer> q = new LinkedList<>();
        q.add(vertex);
        colors[vertex] = col;

        while (!q.isEmpty()) {
            vertex = q.poll();

            for (int node: graph[vertex]) {
                if (colors[node] == -1) {
                    colors[node] = 1 - colors[vertex];
                    q.add(node);
                } else if (colors[node] == colors[vertex]) {
                    return false;
                }
            }
        }
        return true;
    }
}