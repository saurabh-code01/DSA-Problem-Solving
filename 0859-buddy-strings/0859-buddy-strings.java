class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }
        
        if(s.equals(goal)){
            int[]freq=new int[26];
            for(char ch:s.toCharArray()){
                freq[ch-'a']++;
                
            }
            for(char ch:s.toCharArray()){
                if(freq[ch-'a']>1){
                    return true;
                }
            }

            return false;
        }

        List<Integer> list=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=goal.charAt(i)){
                list.add(i);
            }
        }

        if(list.size()==2){
            int first=list.get(0);
            int second=list.get(1);
            return  s.charAt(first)==goal.charAt(second) && s.charAt(second)==goal.charAt(first);
        }
        
        return false;
    }
}