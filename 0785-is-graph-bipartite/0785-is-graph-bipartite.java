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

    private boolean bfs(int[][] graph, int[] colors, int col, int node) {

        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        colors[node] = col;

        while (!q.isEmpty()) {
            node = q.poll();

            for (int vertex: graph[node]) {
                if (colors[vertex] == -1) {
                    colors[vertex] = 1 - colors[node];
                    q.add(vertex);
                } else if (colors[vertex] == colors[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}