class Solution {
    public boolean isPalindrome(String s) {
        s=s.replaceAll("[^a-zA-Z0-9]","");
        s=s.toLowerCase();
        int lp=0,rp=s.length()-1;
        while(lp<rp){
            if(s.charAt(lp)!=s.charAt(rp)){
                return false;
            }
            lp++;
            rp--;
        }
        return true;




        
    }
}