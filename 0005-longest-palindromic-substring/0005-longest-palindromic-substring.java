class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <=1){
            return s;
        }
        String lsp="";
        for(int i=1;i<s.length();i++){
            //for odd length string
            int low=i;
            int high=i;
            while(s.charAt(low)==s.charAt(high)){
                low--;
                high++;
                if(low==-1 || high==s.length()){
                    break;
                }
            }
            String palindromstr= s.substring(low+1, high);
            if(palindromstr.length()>lsp.length()){
                lsp=palindromstr;
            }


            //for even length string 
            low=i-1;
            high=i;
            while(s.charAt(low)==s.charAt(high)){
                low--;
                high++;
                if(low==-1 || high==s.length()){
                    break;
                }
            }
            palindromstr=s.substring(low+1,high);
            if(palindromstr.length()>lsp.length()){
                lsp=palindromstr;
            }
        }
        return lsp;
        
    }
}