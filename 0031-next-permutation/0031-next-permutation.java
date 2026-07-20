class Solution {
    public void nextPermutation(int[] nums) {
        //searching pivot element
        int pivot=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                pivot=i;
                break;
            }else{
                pivot=-1;
            }
        }
        // if array is in decending order 
        if(pivot==-1){
            int lp=0,rp=nums.length-1;
            while(lp<rp){
                int swap=nums[lp];
                nums[lp]=nums[rp];
                nums[rp]=swap;
                lp++;
                rp--;
            }
            return ;
        }
        //finding rightmost element just greater then pivot element
        for(int i=nums.length-1;i>pivot;i--){
            if(nums[i]>nums[pivot]){
                int swp=nums[pivot];
                nums[pivot]=nums[i];
                nums[i]=swp;
                break;
            }
        }
        //reversing array from nums[pivot+1]to nums[n-1]
        int lp=pivot +1,rp=nums.length-1;
        while(lp<rp){
            int swap=nums[lp];
            nums[lp]=nums[rp];
            nums[rp]=swap;
            lp++;
            rp--;
        }
        
    }
}