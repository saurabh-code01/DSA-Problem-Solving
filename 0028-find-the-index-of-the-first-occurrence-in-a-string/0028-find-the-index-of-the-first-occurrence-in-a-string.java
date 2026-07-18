class Solution {
    public int strStr(String haystack, String needle) {
        /*int shift=haystack.length()-needle.length();
        int occur=-1,count=0,fstoccur=Integer.MAX_VALUE;
        for(int s=0;s<=shift;s++){
            if(needle.charAt(0)==haystack.charAt(s)){
                count=1;
                occur=s;
                fstoccur=Math.min(occur,fstoccur);
                for(int j=1;j<needle.length();j++){
                    if(needle.charAt(j)==haystack.charAt(s+1)){
                        s++; 
                        count++;   
                    }
                    else{
                        break;
                    }
                }
                return (count==needle.length())?fstoccur:-1;
            }
        }
        return (count==needle.length())?fstoccur:-1;*/
          


        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i; // full match found
            }
        }
        return -1; // no match

    }
}