class Solution {
    public void sortColors(int[] nums) {
        int j=0;
        while(j<nums.length){
            for(int i=0;i<nums.length-1;i++){
                if(nums[i]>nums[i+1]){
                //swap
                    int temp=nums[i];
                    nums[i]=nums[i+1];
                    nums[i+1]=temp;
                }
                else{
                    continue;
                }
            }
            j++;
        }
        
    }
}