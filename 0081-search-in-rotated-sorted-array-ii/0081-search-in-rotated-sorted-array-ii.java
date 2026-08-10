class Solution {
    public boolean search(int[] nums, int target) {
        Arrays.sort(nums);
        int si=0,ei=nums.length-1;
        while(si<=ei){
            int mid=si+(ei-si)/2;
            if(nums[mid]==target){
                return true; 
            }
            else if(nums[mid]>target){
                ei=mid-1;
            }
            else{
                si=mid+1;
            }
        }
        return false;
        
    }
}