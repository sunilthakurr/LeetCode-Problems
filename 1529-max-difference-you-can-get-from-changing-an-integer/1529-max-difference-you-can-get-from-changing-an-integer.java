class Solution {
    public int maxDiff(int num) {
        int len = (int) Math.log10(num) + 1;
        int firstInteger = (int) (num / Math.pow(10, len - 1));
        int temp = num;
        boolean isMinAtFirstIndex = true;

        int x = -1, y = -1;

        for (int i = 0; i < len; i++) {
            int val = (int) (num / Math.pow(10, len - 1 - i));
            if (val != 9) {
                x = val;
                break;
            }
            num = (int) (num % Math.pow(10, len - 1 - i));
        }
        num = temp;

        for (int i = 0; i < len; i++) {
            int val = (int) (num / Math.pow(10, len - 1 - i));
            if (i != 0) isMinAtFirstIndex = false;
            if (val != 0 && val != 1) {
                y = val;
                break;
            }
            num = (int) (num % Math.pow(10, len - 1 - i));
        }
        num = temp;
        // System.out.println(x+" "+y);

        int maxNumber = 0, minNumber = 0, ind = 0;

        while (num != 0) {
            int val = num % 10;
            num /= 10;
            if (val == x) {
                maxNumber += 9 * Math.pow(10, ind);
            } else {
                maxNumber += val * Math.pow(10, ind);
            }
            if (val == y) {
                if (isMinAtFirstIndex)
                    minNumber += 1 * Math.pow(10, ind);
                else 
                    minNumber += 0 * Math.pow(10, ind);
            } else {
                minNumber += val * Math.pow(10, ind);
            }
            ind++;
        }
        // System.out.println(maxNumber + " " + minNumber);
        return maxNumber - minNumber;
    }
}