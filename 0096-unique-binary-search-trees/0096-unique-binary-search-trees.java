class Solution {
    private int recursive(int n){
        if(n==0 || n==1){
            return 1;
        }
        int sum=0;
        for(int i=0;i<=n-1;i++){
            sum=sum+recursive(i)*recursive(n-1-i);
        }

        return sum;
    }
    public int numTrees(int n) {
        return recursive(n);
        
    }
}