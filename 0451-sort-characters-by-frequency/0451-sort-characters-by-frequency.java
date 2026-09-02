class Solution {
    public String frequencySort(String s) {
        StringBuilder sb=new StringBuilder();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        List<Map.Entry<Character,Integer>> list=new ArrayList<>(map.entrySet());

        list.sort(Map.Entry.<Character,Integer>comparingByValue().reversed());
        Map<Character,Integer> sortedMap=new LinkedHashMap<>();
        for(Map.Entry<Character,Integer> entry :list){
            sortedMap.put(entry.getKey(),entry.getValue());
        }

        Set<Character>keys=sortedMap.keySet();
        for(char K:keys){
            if(sortedMap.get(K)==1){
                sb.append(K);

            }else{
                for(int i=0;i<sortedMap.get(K);i++){
                    sb.append(K);
                }

            }

        }

        return sb.toString();

        
    }
}