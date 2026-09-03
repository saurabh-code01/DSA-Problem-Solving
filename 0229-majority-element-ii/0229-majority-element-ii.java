class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length/3;
        List<Integer> list=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        Set<Integer>keys=map.keySet();
        for(int key:keys){
            if(map.get(key)>n){
                list.add(key);
            }
        }

        return list;



        
    }
}