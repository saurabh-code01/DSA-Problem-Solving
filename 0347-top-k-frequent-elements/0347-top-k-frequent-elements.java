class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            int count=1;
            while(i<nums.length-1 && nums[i]==nums[i+1] ){
                count++;
                i++;
            }

            map.put(nums[i],count);

        }
        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.<Integer,Integer>comparingByValue().reversed());
        Map<Integer,Integer> sortedMap=new LinkedHashMap<>();
        for(Map.Entry<Integer,Integer> entry:list){
            sortedMap.put(entry.getKey(),entry.getValue());
        }

        Set<Integer> keys=sortedMap.keySet();
        Integer[] keysArray = keys.toArray(new Integer[0]);

        int[]result=new int[k];
        for(int i=0;i<k;i++){
            result[i]=keysArray[i];
        }
        
        return result;

        

        
    }
}