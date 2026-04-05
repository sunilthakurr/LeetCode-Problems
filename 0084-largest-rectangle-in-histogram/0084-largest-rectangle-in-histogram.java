class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] left = leftSmaller(heights);
        int[] right = rightSmaller(heights);
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
            System.out.println((right[i] - left[i] - 1) * heights[i]);
        }
        return res;
    }
    private int[] leftSmaller(int[] arr) {

        int n = arr.length;
        int j = 0;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                res[j++] = -1;
            } else {
                res[j++] = st.peek();
            }
            st.add(i);
        }
        return res;
    }

    private int[] rightSmaller(int[] arr) {
        
        int n = arr.length;
        int j = n - 1;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                res[j--] = n;
            } else {
                res[j--] = st.peek();
            }
            st.add(i);
        }
        return res;
    }
}