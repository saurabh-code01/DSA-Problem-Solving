class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int count=1;
            while(i<nums.length-1 && nums[i]==nums[i+1]){
                count++;
                i++;
            }
            map.put(nums[i],count);
        }

        Set<Integer> keys=map.keySet();
        for(Integer k:keys){
            if(map.get(k)==2){
                list.add(k);
            }
        }


        

        return list;
        
    }
}