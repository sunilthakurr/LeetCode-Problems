class Solution {
    public List<Integer> lexicalOrder(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        String [] arr = new String[n];
        int j = 1;
        for(int i = 0; i < n; ++i){
            arr[i] = String.valueOf(j++);
        }
        Arrays.sort(arr);
        for(int i = 0; i < n; ++i){
            list.add(Integer.valueOf(arr[i]));
        }
        return list;
    }
}
