class Solution {

    int cycleStart = -1;
    private void DFS(
        int src,
        boolean[] visited,
        List<Integer>[] adjList,
        int[] parent
    ) {
        visited[src] = true;

        for (int adj : adjList[src]) {
            if (!visited[adj]) {
                parent[adj] = src;
                DFS(adj, visited, adjList, parent);
            } else if (adj != parent[src] && cycleStart == -1) {
                cycleStart = adj;
                parent[adj] = src;
            }
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length;

        boolean[] visited = new boolean[N];
        int[] parent = new int[N];
        Arrays.fill(parent, -1);

        List<Integer>[] adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adjList[edge[0] - 1].add(edge[1] - 1);
            adjList[edge[1] - 1].add(edge[0] - 1);
        }

        DFS(0, visited, adjList, parent);

        Map<Integer, Integer> cycleNodes = new HashMap<>();
        int node = cycleStart;
        do {
            cycleNodes.put(node, 1);
            node = parent[node];
        } while (node != cycleStart);
        for (int i = edges.length - 1; i >= 0; i--) {
            if (
                cycleNodes.containsKey(edges[i][0] - 1) &&
                cycleNodes.containsKey(edges[i][1] - 1)
            ) {
                return edges[i];
            }
        }

        return new int[] {};
    }
}