class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        HashMap<Character,Integer> map1=new HashMap<>();
        for(int i=0;i<ransomNote.length();i++){
            map1.put(ransomNote.charAt(i),map1.getOrDefault(ransomNote.charAt(i),0)+1);
        }
        HashMap<Character,Integer> map2=new HashMap<>();
        for(int i=0;i<magazine.length();i++){
            map2.put(magazine.charAt(i),map2.getOrDefault(magazine.charAt(i),0)+1);
        }

        Set<Character> keys=map1.keySet();
        for(char key:keys){
            if(map2.containsKey(key)){
                if(map2.get(key)<map1.get(key)){
                    return false;
                }
            }else{
                return false;
            }
        }   

        return true; 


        
    }
}