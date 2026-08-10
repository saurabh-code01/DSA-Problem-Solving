class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length-1;
        if(n==0){
            return n;
        }
        if(nums[0]>nums[1]){
            return 0;
        }
        if(nums[n]>nums[n-1]){
            return n;
        }

        for(int i=1;i<n;i++){
            int mid=i;
            int si=mid-1;
            int ei=mid+1;

            if(nums[mid]>nums[si] && nums[mid]>nums[ei]){
                return mid;
                
            }
        }

        return -1;
        
    }
}