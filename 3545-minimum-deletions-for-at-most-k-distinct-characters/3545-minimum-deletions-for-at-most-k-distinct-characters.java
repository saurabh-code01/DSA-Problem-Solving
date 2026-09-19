class Solution {
    public int minDeletion(String s, int k) {
        HashMap<Character,Integer> map=new HashMap<>();
        int ans=0;
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        if(map.size()==k){
            return ans;

        }



        //sorting of hashmap according to value;
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        Map<Character, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        if(sortedMap.size()>k){
            while(sortedMap.size()!=k){
                Set<Character> keys=sortedMap.keySet();
                for(char key:keys){
                    ans+=sortedMap.get(key);
                    sortedMap.remove(key);
                    break ;
                }   // remove from the sortedmap 
                   
            }
        }

        return ans;
        
    }
}