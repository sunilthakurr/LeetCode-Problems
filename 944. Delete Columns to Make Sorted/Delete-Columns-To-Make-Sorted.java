class Solution {
    public int minDeletionSize(String[] arr) {
    int count = 0;
    for(int i=0; i<arr[0].length(); i++){
        for(int j=1; j<arr.length; j++){
            if(arr[j].charAt(i) < arr[j-1].charAt(i)){
                count++;
                break;
            }
        }
    }     
    return count;
}
}
