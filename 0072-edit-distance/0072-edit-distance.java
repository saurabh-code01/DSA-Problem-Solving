class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();

        int[][]DP=new int[m+1][n+1];
        DP[0][0]=0;
        
        // initializing 1st column
        for(int i=1;i<=m;i++){
            DP[i][0]=i;
        }
        //initializing 1st row
        for(int j=1;j<=n;j++){
            DP[0][j]=j;
        }

        // filling all spaces
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                int topl=DP[i-1][j-1];
                int top=DP[i-1][j];
                int left=DP[i][j-1];
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    // print the minimal
                    DP[i][j]=topl;
                }
                else{
                    // print the minimal+1
                    DP[i][j]=(Math.min(topl,Math.min(top,left))) +1;

                }
            }
        }

        return DP[m][n];
        

        
    }
}