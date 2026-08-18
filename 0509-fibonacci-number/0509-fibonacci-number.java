class Solution {
    public int fib(int n) {
        int[] series=new int[n+1];
        if(n==0) return 0;
        if(n==1) return 1;
        series[0]=0;
        series[1]=1;
        for(int i=2;i<=n;i++){
            series[i]=series[i-1]+series[i-2];
        }
        return series[n-1]+series[n-2];
        
    }
}