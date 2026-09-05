/*class Solution {
    private boolean ishelper(String s,String p,HashMap<Character,Integer> map,int st,int ei){
        for(int i=st;i<=ei;i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0;i<p.length();i++){
            if(map.containsKey(p.charAt(i))){
                if(map.get(p.charAt(i)) == 1){
                    map.remove(p.charAt(i));
                }else{
                    map.put(p.charAt(i),map.get(p.charAt(i))-1);
                }
            }
        }
        int n=map.size();
        return n==0?true:false;
    }
    public List<Integer> findAnagrams(String s, String p) {
        int n=p.length();
        List<Integer> list=new ArrayList<>();
        if(p.length()>s.length()){
            return list;
        }
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<=s.length()-n;i++){
            if(ishelper(s,p,map,i,i+n-1)){
                list.add(i);
            }
            map.clear();
        }

        return list;
        
        
    }
}*/
import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Count frequency of p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        int n = p.length();

        // First window
        for (int i = 0; i < n; i++) {
            sCount[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pCount, sCount)) {
            result.add(0);
        }

        // Slide window
        for (int i = n; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++; // add new char
            sCount[s.charAt(i - n) - 'a']--; // remove old char

            if (Arrays.equals(pCount, sCount)) {
                result.add(i - n + 1);
            }
        }

        return result;
    }
}
