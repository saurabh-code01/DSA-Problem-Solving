class Solution {
    private long[][] PT;
    private int MOD=1000000007;
    public int numOfWays(int[] nums) {
        PT  =new long[nums.length+1][nums.length+1];
        buildPT(nums.length);
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        return (int)((solve(list)-1 +MOD)% MOD);
    }

    private long solve(List<Integer> list){ 
        int n=list.size();
        if(n<=2){
            return 1;
        }    
        List<Integer> left=new ArrayList<>();
        List<Integer> right=new ArrayList<>();
        
        int root=list.get(0);
        for(int i=1;i<n;i++){
            if(list.get(i)>root){
                right.add(list.get(i));

            }else{
                left.add(list.get(i));
            }
        }

        long x=solve(left);
        long y=solve(right);
        long z=PT[n-1][left.size()];
        return  (x*y % MOD)*z % MOD;
        
    }
    private void buildPT(int n){
        for(int i=0;i<=n;i++){
            PT[i][0]=PT[i][i]=1;
            for(int j=1;j<i;j++){
                PT[i][j]=(PT[i-1][j]+PT[i-1][j-1])% MOD;

            }
        }
    }
}