class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        for(int a=0;a<nums.length;a++){
            if(a>0 && nums[a]==nums[a-1])continue;
            for(int b=a+1;b<nums.length;){
                int lp=b+1,rp=nums.length-1;
                while(lp<rp){
                    long sum=(long)nums[a]+nums[b]+nums[lp]+nums[rp];
                    if(sum==target){
                        List<Integer>arr=new ArrayList<>();
                        arr.add(nums[a]);
                        arr.add(nums[b]);
                        arr.add(nums[lp]);
                        arr.add(nums[rp]);
                        result.add(arr);
                        lp++;
                        rp--;
                        while(lp<rp && nums[lp]==nums[lp-1]){
                            lp++;
                        }
                    }
                    else if(sum>target){
                        rp--;
                    }
                    else{
                        lp++;
                    }
                }
                b++;
                while(b<nums.length && nums[b]==nums[b-1]){
                    b++;
                }
                    
                
            }
        }
        return result;  
    }
}