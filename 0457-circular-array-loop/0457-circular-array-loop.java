class Solution {
    private int getnextIdx(int[] nums,int curr){
        int nextIdx=(curr+nums[curr])%nums.length;
        if(nextIdx<0){
            nextIdx+=nums.length;
        }

        return nextIdx;
    }
    public boolean circularArrayLoop(int[] nums) {
        
        for(int i=0;i<nums.length;i++){
            HashSet<Integer> set=new HashSet<>();
            boolean isForward=nums[i]>0;
            int curr=i;
            while(true){
                boolean currDict=nums[curr]>0;
                if(currDict != isForward){
                    break ;
                }
                
                int nextIdx=getnextIdx(nums,curr);
                if(nextIdx==curr){
                    break;
                }

                if(set.contains(nextIdx)){
                    return true;
                }
                set.add(curr);
                curr=nextIdx;
            }

            
        }
        return false;
        
        
    }
}