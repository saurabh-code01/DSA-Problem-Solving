class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String,Integer> map1=new HashMap<>();
        HashMap<String,Integer> map2=new HashMap<>();
        int min=Integer.MAX_VALUE;

        for(int i=0;i<list1.length;i++){
            map1.put(list1[i],i);
        }

        for(int i=0;i<list2.length;i++){
            map2.put(list2[i],i);
        }
        

        HashMap<String,Integer> map=new HashMap<>();
        Set<String> keys=map1.keySet();
        for(String key:keys){
            if(map2.containsKey(key)){
                map.put(key,map1.get(key)+map2.get(key));
                min=Math.min(min,map1.get(key)+map2.get(key));
            }
        }

        
        List<String> list=new ArrayList<>();
        Set<String>KEYS=map.keySet();
        for(String key:KEYS){
            if(map.get(key)==min){
                list.add(key);
            }
        }

        return list.toArray(new String[0]);




    }
}