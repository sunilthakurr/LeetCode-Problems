class Solution {
    class Pair {
        int first;
        int second;
        
        public Pair (int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    class ArrayPairSorter {
        public static void sort(Pair[] arr) {
            Comparator<Pair> comparator = new Comparator<>() {
                public int compare(Pair p1, Pair p2) {
                    return p1.first - p2.first;
                }
            };
            Arrays.sort(arr, comparator);
        }
    }
    public int[][] merge(int[][] intervals) {
        
        int size = intervals.length;

        Pair[] arr = new Pair[size];

        for (int i = 0; i < size; i++) {
            arr[i] = new Pair(intervals[i][0], intervals[i][1]);
        }
        
        ArrayPairSorter.sort(arr);

        List<int[]> list = new ArrayList<>();

        int si = arr[0].first;
        int ei = arr[0].second;

        for (int i = 1; i < size; i++) {
            if (ei >= arr[i].first) {
                ei = Math.max(ei, arr[i].second);
            } else {
                int[] el = new int[2];
                el[0] = si;
                el[1] = ei;
                list.add(el);
                si = arr[i].first;
                ei = arr[i].second;
            }
        }

        if (list.size() == 0 || ei > list.get(list.size() - 1)[1]) {
            int[] temp = new int[2];
            temp[0] = si;
            temp[1] = ei;
            list.add(temp);
        }

        int[][] result = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i)[0];
            result[i][1] = list.get(i)[1];
        }
        return result;
    }
}