class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        Integer[] bitArray = new Integer[n];

        for (int i = 0; i < n; i++) {
            bitArray[i] = arr[i];
        }

        Arrays.sort(bitArray, (a, b) -> {
            int bitCountA = Integer.bitCount(a);
            int bitCountB = Integer.bitCount(b);

            if (bitCountA == bitCountB) {
                return a - b;
            }
            return bitCountA - bitCountB;
        });
        for (int i = 0; i < n; i++) {
            arr[i] = bitArray[i];
        }
        return arr;
    }
}