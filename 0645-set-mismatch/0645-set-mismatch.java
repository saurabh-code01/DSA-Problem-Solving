class Solution {
    public int[] findErrorNums(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        List<Integer> list=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        Set<Integer> keys=map.keySet();
        for(int key:keys){    // add the repeated no.
            if(map.get(key)>1){
                list.add(key);
            }
        }

        for(int i=1;i<=nums.length;i++){   // add missing no.
            if(!map.containsKey(i)){
                list.add(i);
            }
        }

        int[] ans=new int[list.size()];
        for(int i=0;i<ans.length;i++){
            ans[i]=list.get(i);
        }

        return ans;
        
    }
}