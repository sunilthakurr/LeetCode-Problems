class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        List<List<Integer>> adj = new ArrayList<>();
        int V = graph.length;

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[V];
        for (int i = 0; i < graph.length; i++) {
            for (int el: graph[i]) {
                adj.get(el).add(i);
                indegree[i]++;
            }
        }
        return kahnAlgorithm(adj, V, indegree);
    }

    private List<Integer> kahnAlgorithm(List<List<Integer>> adj, int V, int[] indegree) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);

            for (int vertex: adj.get(node)) {
                indegree[vertex]--;
                
                if (indegree[vertex] == 0) {
                    q.add(vertex);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}