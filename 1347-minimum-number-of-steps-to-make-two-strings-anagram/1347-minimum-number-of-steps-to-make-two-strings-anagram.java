class Solution {
    public int minSteps(String s, String t) {
        int count=0;
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }


        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(freq[ch-'a']>0){
                freq[ch-'a']--;
                count++;
            }
        }

        return t.length()-count;
        
    }
}