class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> mp = new HashMap<>();

        mp.put('b', 0);
        mp.put('a', 0);
        mp.put('l', 0);
        mp.put('o', 0);
        mp.put('n', 0);

        for(char ch : text.toCharArray()) {
            if(mp.containsKey(ch)) {
                mp.put(ch, mp.get(ch) + 1);
            }
        }

        int minPos = Integer.MAX_VALUE;
        int noL = 0;
        int noO = 0;

        for(var entry : mp.entrySet()) {
            minPos = Math.min(minPos, entry.getValue());

            if(entry.getKey() == 'l')
                noL = entry.getValue();

            if(entry.getKey() == 'o')
                noO = entry.getValue();
        }

        if(noL < 1 || noO < 1)
            return 0;

        noL -= noL % 2;
        noO -= noO % 2;

        return Math.min(minPos, Math.min(noL / 2, noO / 2));
    }
}