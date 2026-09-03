class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int num=0;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }

        for(int i=0;i<=n;i++){
            if(!set.contains(i)){
                num=i;

            }
        }
        return num;
        
    }
}