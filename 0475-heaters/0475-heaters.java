class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int radius=0;
        // step 1
        Arrays.sort(houses);
        Arrays.sort(heaters);

        //step 2 
        for(int house :houses){
            int idx=Arrays.binarySearch(heaters,house);
            if(idx<0){
                idx=-(idx+1);
            }

            int leftdist=(idx-1>=0)? house -heaters[idx-1]:Integer.MAX_VALUE;
            int rightdist=(idx<heaters.length)? heaters[idx]-house:Integer.MAX_VALUE;

            int nearest=Math.min(leftdist,rightdist);
            //step 3
            radius=Math.max(radius,nearest);

        }

        return radius;
        



        
        
    }
}