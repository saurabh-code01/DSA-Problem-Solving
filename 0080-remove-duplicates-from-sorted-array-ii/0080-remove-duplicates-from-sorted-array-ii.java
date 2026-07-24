class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0,j=1,count=1;
        while(j<nums.length){
            if(nums[i]==nums[j]){
                if(count==1){
                
                    i++;
                    nums[i]=nums[j];
                    count++;
                }    
                               
            }
            else {
                i++;
                nums[i]=nums[j];
                count=1;
            }
            j++;
        }
        return i+1;
    }
}