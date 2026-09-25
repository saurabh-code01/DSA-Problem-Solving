class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase().replaceAll("[^a-zA-Z]", " ");
        String[] words = paragraph.trim().split("\\s+");
        HashMap<String,Integer> map=new HashMap<>();

        HashSet<String> set=new HashSet<>(Arrays.asList(banned));

        for(int i=0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }

        List<Map.Entry<String,Integer>>list=new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.<String, Integer>comparingByValue().reversed());
        Map<String,Integer> sortedMap=new LinkedHashMap<>();
        for(Map.Entry<String,Integer> entry:list){
            sortedMap.put(entry.getKey(),entry.getValue());

        }
        String str="";
        Set<String> keys=sortedMap.keySet();
        for(String key:keys){
            if(!set.contains(key)){
                str=key;
                break;
            }
        }

        return str;
    }
}