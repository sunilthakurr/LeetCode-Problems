/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int bitonicPoint = getBitonicPoint(target, mountainArr);
        System.out.println(bitonicPoint);
        if (target > mountainArr.get(bitonicPoint))
            return -1;
        
        int op1 = binarySearch(mountainArr, 0, bitonicPoint, target);
        int op2 = descendingBinarySearch(mountainArr, bitonicPoint + 1, mountainArr.length() - 1, target);
        
        if (op1 != -1) {
            return op1;
        }
        return op2;
    }
    private int descendingBinarySearch(MountainArray mountainArray, int si, int ei, int target) {
        int ans = -1;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            int midElement = mountainArray.get(mid);

            if (midElement == target) {
                ans = mid;
                ei = mid - 1;
            } else if (midElement > target) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }
        return ans;
    }
    private int binarySearch(MountainArray mountainArray, int si, int ei, int target) {
        int ans = -1;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            int midElement = mountainArray.get(mid);

            if (midElement == target) {
                ans = mid;
                ei = mid - 1;
            } else if (midElement > target) {
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }
        return ans;
    }
    private int getBitonicPoint(int target, MountainArray mountainArray) {
        int n = mountainArray.length();
        
        int ans = -1;
        int si = 0;
        int ei = n - 1;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            int midElement = mountainArray.get(mid);

            // if (midElement == target) {
            //     ans = mid;
            // }
            // System.out.println("mid :- "+mid);
            if (mid > 0 && mid < n - 1) {
                int prev = mountainArray.get(mid - 1);
                int next = mountainArray.get(mid + 1);

                if (midElement > prev && midElement > next) {
                    return mid;
                } else if (midElement < prev) {
                    ei = mid - 1;
                } else {
                    si = mid + 1;
                }
            } else if (mid == 0) {
                if (midElement > mountainArray.get(1)) {
                    return 0;
                } else {
                    return 1;
                }
            } else if (mid == n - 1) {
                if (midElement > mountainArray.get(mid - 2)) {
                    return n - 1;
                } else {
                    return n - 2;
                }
            }
        }
        return -1;
    }
}