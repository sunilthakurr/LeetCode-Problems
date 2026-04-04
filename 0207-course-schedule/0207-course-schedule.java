class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int firstTask = prerequisites[i][1];
            int secondTask = prerequisites[i][0];

            adj.get(firstTask).add(secondTask);
        }
        return kahnAlgorithm(adj, prerequisites, numCourses);
    }
    
    private boolean kahnAlgorithm(List<List<Integer>> adj, int[][] edges, int V) {

        int[] indegree = new int[V];

        for (int i = 0; i < edges.length; i++) {
            indegree[edges[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        
        int cnt = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            ++cnt;

            for (int vertex: adj.get(node)) {
                indegree[vertex]--;

                if (indegree[vertex] == 0) {
                    q.add(vertex);
                }
            }
        }
        return cnt == V;
    }
}