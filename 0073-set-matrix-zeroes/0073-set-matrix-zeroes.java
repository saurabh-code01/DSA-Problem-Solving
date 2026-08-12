class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        boolean rowzero=false;
        boolean colzero=false;
        // step 1
        for(int j=0;j<n;j++){   // 1st row check
            if(matrix[0][j]==0){
                rowzero=true;
                break;
            }
        }
        for(int i=0;i<m;i++){  //1st column check
            if(matrix[i][0]==0){
                colzero=true;
                break;
            }
        }
        // step 2
        for(int i=1;i<m;i++){  // marking in 1st row and 1st column
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        // step 3
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        // step 4
        if(rowzero==true){
            for(int j=0;j<n;j++){
                matrix[0][j]=0;
            }
        }
        if(colzero==true){
            for(int i=0;i<m;i++){
                matrix[i][0]=0;
            }
        }

        
    }
}