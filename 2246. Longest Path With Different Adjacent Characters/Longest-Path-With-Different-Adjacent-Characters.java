class Solution {
    public int longestPath(int[] parent, String s) {
        List<Integer>[] graph = new List[parent.length];
        for(int i = 0; i < parent.length; i++)
            graph[i] = new ArrayList<>();

        for(int i = 1; i < parent.length; i++)
            graph[parent[i]].add(i);

        helper_DFS(graph, 0, -1, s.toCharArray());
        return longestPath;
    }
    private int longestPath = 1;
    private int helper_DFS(List<Integer>[] graph, int node, int parent, char[] s){
        int currMax = 0;
        for (int neighbour : graph[node]) {
            if (neighbour == parent) continue;

            int subChain = helper_DFS(graph, neighbour, node, s) + 1;
            if (s[node] == s[neighbour]) continue;

            longestPath = Math.max(longestPath, 1 + currMax + subChain);
            currMax = Math.max(currMax, subChain);
            longestPath = Math.max(longestPath, currMax);
        }
        return currMax;
    }
}
