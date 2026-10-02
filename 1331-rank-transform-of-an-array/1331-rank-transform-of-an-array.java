class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        int[] ans=new int[n];
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        Set<Integer> keys=map.keySet();
        int rank=1;
        for(int key:keys){
            map.put(key,rank);
            rank++;

        }

        for(int i=0;i<ans.length;i++){
            ans[i]=map.get(arr[i]);
        }

        return ans;
        
    }
}