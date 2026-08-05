class Solution {
    public int countSubstrings(String s) {
        if(s.length() < 1){
            return 1;
        }
        int count=1;
        int num=0;
        for(int i=1;i<s.length();i++){
            int low=i,high=i;
            while(s.charAt(low)==s.charAt(high)){
                low--;
                high++;
                count++;
                if(low==-1||high==s.length()){
                    break;
                }
            }
            low=i-1;
            high=i;
            while(s.charAt(low)==s.charAt(high)){
                low--;
                high++;
                num++;
                if(low==-1||high==s.length()){
                    break;
                }
            }

            
        }
        int ans=count+num;
        return ans;
        
    }
}