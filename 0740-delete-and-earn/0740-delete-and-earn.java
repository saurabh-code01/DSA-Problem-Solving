class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        
        // step 1
        int maxval=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            maxval=Math.max(maxval,nums[i]);
        }
        

        // step 2
        int[] arr=new int[maxval+1];
        Set<Integer> keys=map.keySet();
        for(int key:keys){
            arr[key]=key*map.get(key);
        }         

        // step 3(house robber Approach)
        if(maxval==0){
            return arr[0];
        }
        int prev2=arr[0];
        int prev1=Math.max(arr[0],arr[1]);
        for(int i=2;i<arr.length;i++){
            int current=Math.max(prev1,prev2+arr[i]);
            prev2=prev1;
            prev1=current;


        }

        return prev1;


        
    }
}