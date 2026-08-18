class Solution {
    private int series(int i,int[] nums,int diff){
        for(int j=i+1;j<nums.length;j++){
            if(nums[j]-nums[i]==diff){
                return j;
            }
        }

        return -1;

    }
    public int longestArithSeqLength(int[] nums) {
        
        int max=2;
        for(int i=0;i<nums.length;i++){
            for(int k=i+1;k<nums.length;k++){
                int count=2;
                int diff=nums[k]-nums[i];

            // check for this diff to come again or not 
                int j=k;
                while(true){
                    j=series(j,nums,diff);
                    if(j==-1){
                        break;
                    }
                    count++;
                }
            
                max=Math.max(max,count);
            }

        }

        return max;
        
    }
}