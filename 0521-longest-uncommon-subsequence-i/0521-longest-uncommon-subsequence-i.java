class Solution {
    public int findLUSlength(String a, String b) {
        //StringBuilder sb=new StringBuilder();
        if(a.equals(b)){
            return -1;
        }
            
        return Math.max(a.length(),b.length());
        

        /*int n=Math.min(a.length(),b.length());
        for(int i=0;i<n;i++){
            if(a.charAt(i)!=b.charAt(i)){
                sb.append(b.charAt(i));
            }
        }

        return sb.length();
        */
    }
}