class Solution {
    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for(int i = 0; i < chars.length; i++){
            list.add(chars[i]);
        }
        Collections.sort(list);
        int counter = 1;
        list.add(',');
        Character ch = list.get(0);
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<Character> characters = new ArrayList<>();
        for(int i = 1; i < list.size(); i++){
            if(ch == list.get(i)){
                counter++;
            } else {
                integers.add(counter);
                characters.add(ch);
                counter = 1;
                ch = list.get(i);
            }
        }
        // System.out.println(integers);
        // System.out.println(characters);
        
        
        for (int i = 0; i < integers.size(); i++) {
          for (int j = 1; j < (integers.size() - i); j++) {
            if (integers.get(j - 1) < integers.get(j)) {
              
              int temp = integers.get(j - 1);
              integers.set(j - 1,integers.get(j));
              integers.set(j, temp);
                
              Character temps = characters.get(j - 1);
              characters.set((j - 1),characters.get(j));
              characters.set(j, temps);
            }
          }
        }
        
        String result = "";
        
        for (int i = 0; i < integers.size(); i++) {
            for (int j = 0; j < integers.get(i); j++) {
                result += characters.get(i);
                
            }
        }

        
        return result;
        
    }
    
}