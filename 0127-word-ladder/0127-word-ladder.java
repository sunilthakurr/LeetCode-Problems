class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        // wordList.add(endWord);

        Map<String, List<String>> adj = new HashMap<>();
        Map<String, Integer> map = new HashMap<>();

        for (String adjNode: wordList) {
            adj.put(adjNode, new ArrayList<>());
        }

        for (int i = 0; i < wordList.size(); i++) {
            String src = wordList.get(i);
            for (int j = i + 1; j < wordList.size(); j++) {
                String dest = wordList.get(j);

                if (isAdjacentPair(src, dest)) {
                    List<String> list1 = adj.get(src);
                    list1.add(dest);
                    adj.put(src, list1);
                    List<String> list2 = adj.get(dest);
                    list2.add(src);
                    adj.put(dest, list2);
                }
            }
        }

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        map.put(beginWord, 0);

        while (!q.isEmpty()) {
            String node = q.poll();

            for (String adjNode: adj.get(node)) {
                if (!map.containsKey(adjNode)) {
                    q.add(adjNode);
                    map.put(adjNode, map.get(node) + 1);
                } else {
                    map.put(adjNode, Math.min(map.get(node) + 1, map.get(adjNode)));
                }
            }
        }
        
        System.out.println(map.toString());
        if (!map.containsKey(endWord)) {
            return 0;
        }
        return map.get(endWord) + 1;
    }

    private boolean isAdjacentPair(String str1, String str2) {
        int cnt = 0;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                ++cnt;
            }
            if (cnt > 1) {
                return false;
            }
        }
        return true;
    }
}