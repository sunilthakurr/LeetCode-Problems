class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>();

        for(int i=0;i<queries.length;i++){
            String current_q = queries[i];
            for(int j=0;j<dictionary.length;j++){
                String current_d = dictionary[j];
                int cnt=0;
                for(int check=0;check<current_q.length();check++){
                    if(current_q.charAt(check)!=current_d.charAt(check)){
                     cnt++;
                    if(cnt>2) break;
                    }
                }
                 if (cnt <= 2) {
                    res.add(current_q);
                    break; 
                }
            
            }
              
        }
        return res;
    }
}