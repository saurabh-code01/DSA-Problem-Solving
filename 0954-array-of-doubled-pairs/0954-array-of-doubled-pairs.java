class Solution {
    public boolean canReorderDoubled(int[] arr) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        
        Integer[] keys = map.keySet().toArray(new Integer[0]);
        Arrays.sort(keys, (a, b) -> Integer.compare(Math.abs(a), Math.abs(b)));

        for(int key:keys){
            if(map.get(key)==0){
                continue;
            }
            int target=2*key;
            if(map.getOrDefault(target,0)<map.get(key)){
                return false;
            }

            map.put(target,map.get(target)-map.get(key));

        }

        return true;
    }
}