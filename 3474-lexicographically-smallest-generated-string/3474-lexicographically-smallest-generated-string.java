class Solution {
    public String generateString(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        char[] res = new char[n + m - 1];
        Arrays.fill(res, 'a');
        BitSet vis = new BitSet(10600);
        for(int i=0; i<n; i++){
            if(s1.charAt(i) == 'T'){
                for(int j=0; j<m; j++){
                    res[i+j] = s2.charAt(j);
                    vis.set(i+j);
                }
            }
        }
        for(int i=0; i<n; i++){
            if(s1.charAt(i) == 'F'){
                boolean match = true;
                for(int j=0; j<m; j++){
                    if(res[i+j] != s2.charAt(j)){
                        match = false; break;
                    }
                }
                if(match){
                    for(int j=m-1; j>=0; j--){
                        if(!vis.get(i+j)){
                            res[i+j] = 'b'; break;
                        }
                    }
                }
            }
        }
        for(int i=0; i<n; i++){
            boolean match = true;
            for(int j=0; j<m; j++){
                if(res[i+j] != s2.charAt(j)){
                    match = false; break;
                }
            }
            if( (s1.charAt(i) == 'T' && !match ) || (s1.charAt(i) == 'F' && match ) ) return "";
        }
        return new String(res);
    }
}