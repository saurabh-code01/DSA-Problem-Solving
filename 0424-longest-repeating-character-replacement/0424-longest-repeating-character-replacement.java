class Solution {
    public int characterReplacement(String s, int k) {
        int freq[]=new int [26];
        int left=0;
        int maxfreq=0;
        int maxwindow=0;
        for(int right=0;right<s.length();right++){
            freq[s.charAt(right)-'A']++;    //maintaining the chartof frequency for every alphabet
            maxfreq=Math.max(maxfreq,freq[s.charAt(right)-'A']);
            int windowlength=right-left+1;
            if((windowlength-maxfreq)>k){    //reducing window
                freq[s.charAt(left)-'A']--;
                left++;
            }
            windowlength=right-left+1;
            maxwindow=Math.max(maxwindow,windowlength);

        }
        return maxwindow;
        
    }
}