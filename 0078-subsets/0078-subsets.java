class Solution {
    private void backtrack(List<List<Integer>> resultsets,List<Integer>tempsets,int[]nums,int start ){
        resultsets.add(new ArrayList<>(tempsets));
        for(int i=start;i<nums.length;i++){
            tempsets.add(nums[i]);
            backtrack(resultsets,tempsets,nums,i+1);
            tempsets.remove(tempsets.size()-1);
        }

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultsets=new ArrayList<>();
        backtrack(resultsets,new ArrayList<>(),nums,0);
        return resultsets;
        
    }
}