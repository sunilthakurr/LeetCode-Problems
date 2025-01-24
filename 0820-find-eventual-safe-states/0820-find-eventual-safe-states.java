class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = graph.length;
        int[] indegree = new int[n];
        for(int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph[i].length; j++) {
                adj.get(graph[i][j]).add(i);
                indegree[i]++;
            }
        }
        
       

        // for(int i = 0; i < adj.size(); i++) {
        //     for(int j = 0; j < adj.get(i).size(); j++) {
        //         indegree[adj.get(i).get(j)]++;
        //     }
        // }
        System.out.println(Arrays.toString(indegree));
        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeStates = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int node = q.poll();
            safeStates.add(node);

            for(int neighbor: adj.get(node)) {
                indegree[neighbor]--;
                System.out.println("neighbor "+neighbor+" indegree :- "+indegree[neighbor]);
                if(indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
        Collections.sort(safeStates);
        return safeStates;
    }
}