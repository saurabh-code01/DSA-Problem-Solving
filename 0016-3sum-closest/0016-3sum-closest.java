import java .util.Arrays;
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            int j=i+1,k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                int diff=0;
                if(sum<target){
                    j++;
                }
                else if(sum>target){
                    k--;
                }
                else{
                    j++;
                    k--;
                    return sum;
                }
                diff=Math.abs(sum-target);
                if(diff<min){
                    min=diff;
                    ans=sum;
                }
            }
        }
        return ans;
        
    }
}