class Solution {
    public int findShortestSubArray(int[] nums) {
        int n=nums.length;
        int ans=Integer.MAX_VALUE;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        /*List<Map.Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.<Integer,Integer>comparingByValue().reversed());
        Map<Integer,Integer> sortedmap=new LinkedHashMap<>();
        for( Map.Entry<Integer,Integer> entry:list){
            sortedmap.put(entry.getKey(),entry.getValue());
        }*/
        
        
        Set<Integer> keys=map.keySet();
        int maxfreq=0;
        for(int key:keys){
            maxfreq=Math.max(maxfreq,map.get(key));

        }
        for(int key:keys){
            if(map.get(key)==maxfreq){
                int start=0,end=0;

                for(int i=0;i<n;i++){
                    if(nums[i]==key){
                        start=i;
                        break;
                    }
                }

                for(int i=n-1;i>=0;i--){
                    if(nums[i]==key){
                        end=i;
                        break;
                    }
                }
                ans=Math.min(ans,end-start+1);
            }
            
        }

        return ans;


        
    }
}