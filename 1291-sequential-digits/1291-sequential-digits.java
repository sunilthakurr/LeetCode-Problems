class Solution {
    public List sequentialDigits(int low, int high) {

        int l = Integer.toString(low).length();
        int h = Integer.toString(high).length();

        List arr = new ArrayList();

        for(int i=l;i<=h;i++){
            int count = 1, j = i;
            while(j<=9){
                int number = 0;
                for(int k=count;k<=j;k++)
                    number = number*10+k;
                if(number>high)
                    return arr;
                count++;
                j++;
                if(number<low)
                    continue;
                arr.add(number);
            }
        }
        
        return arr;
    }
}

