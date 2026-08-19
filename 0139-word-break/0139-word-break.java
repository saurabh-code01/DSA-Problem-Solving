class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String>dict=new HashSet<>(wordDict);
        int n=s.length();
        boolean[]dp=new boolean[n+1];
        dp[0]=true;

        int maxlen=0;
        for(String word:wordDict){
            maxlen=Math.max(maxlen,word.length());
        }
        for(int i=1;i<n+1;i++){
            for(int j=i-1;j>=Math.max(0,i-maxlen);j--){
                if(dp[j] && dict.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];
        
    }
}