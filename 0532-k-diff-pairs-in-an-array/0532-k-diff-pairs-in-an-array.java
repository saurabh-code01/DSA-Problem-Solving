class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        List<List<Integer>>result=new ArrayList<>();
        List<Integer> list;
        for(int i=0;i<nums.length-1;i++){
            list=new ArrayList<>();
            for(int j=i+1;j<nums.length;j++){
                if(Math.abs(nums[i]-nums[j])==k){
                    list.add(nums[i]);
                    list.add(nums[j]);
                    break;
                }

            }
            if(list.size()!=0 &&  !result.contains(list)){
                result.add(list);

            }
            
        }

        return result.size();
        
    }
}