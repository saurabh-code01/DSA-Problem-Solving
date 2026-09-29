class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int pair=0;
        int[] count=new int[100];
        for(int[] d: dominoes){
            int val=d[0]<d[1]?d[0]*10+d[1]:d[1]*10+d[0];
            pair+=count[val];
            count[val]++;

        }
        
        return pair;
        
    }
}