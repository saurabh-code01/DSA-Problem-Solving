class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length<1){
            return 0;
        }
        int count=1,len=Integer.MIN_VALUE;
        Arrays.sort(nums);
        int i=nums.length-1;
        while(i>0){
            if(nums[i]==nums[i-1]+1){
                count++;
            }
            if(nums[i]>nums[i-1] +1  && count>1){
                len=Math.max(len,count);
                count=1;  
            }
            i--;
            
        }
        len =Math.max(len,count);

        

        return len;

        
    }
}