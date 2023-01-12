class Solution {
    
    private Map<Character, Integer> dfs(Integer node, 
                      Map<Integer, List<Integer>> g, 
                      int[] res, 
                      String labels,
                      Set<Integer> visited){
        visited.add(node);
        List<Integer> children = g.get(node);
        
        List<Map<Character, Integer>> maps = new ArrayList<>();
        for(Integer u : children){
            if(!visited.contains(u))
                maps.add(dfs(u, g, res, labels, visited));
        }
        
        Map<Character, Integer> freqMap = new HashMap<>();
        for(Map<Character, Integer> curMap : maps){
            for(char c = 'a'; c<='z'; c++){
                freqMap.put(c, freqMap.getOrDefault(c, 0) + curMap.getOrDefault(c, 0));
            }
        }
        
        char l = labels.charAt(node);
        freqMap.put(l, freqMap.getOrDefault(l, 0) + 1);
        res[node] = freqMap.get(l);
        return freqMap;
    }
    
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for(int[] edge : edges){
            g.putIfAbsent(edge[0], new ArrayList<>());
            g.putIfAbsent(edge[1], new ArrayList<>());
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
        }
        
        int[] res = new int[n];
        dfs(0, g, res, labels, new HashSet<>());
        return res;
    }
}
