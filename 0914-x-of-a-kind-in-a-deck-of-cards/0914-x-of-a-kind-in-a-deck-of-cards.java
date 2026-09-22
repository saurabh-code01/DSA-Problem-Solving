class Solution {
    private int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<deck.length;i++){
            map.put(deck[i],map.getOrDefault(deck[i],0)+1);
        }

        int gcdVal=0;
        for(int val:map.values()){
            gcdVal=gcd(gcdVal,val);
        }

        return gcdVal>=2;
    }
}