import java.util.Map.Entry;
class Solution {
    public int minimumRounds(int[] tasks) {
        return RoundCounter(tasks, tasks.length);
    }
    public static int RoundCounter(int[] arr, int N){

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : arr){
            if(!map.containsKey(i))
                map.put(i, 1);
            else
                map.put(i, map.get(i) + 1);
        }
//        System.out.println(map);
        int count = 0;
        for(Entry<Integer, Integer> mapEle : map.entrySet()){
            int val = mapEle.getValue();
//            System.out.print(val+" ");
            if(val < 2)
                return -1;
            if(val == 2 || val == 3)
                ++count;
            else{
                count += val / 3;
                if(val % 3 != 0)
                    ++count;
            }
        }
        return count;
    }
}
