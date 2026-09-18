class Solution {
    private boolean issubsequence(String a,String b){
        int i=0,j=0;
        while(i<a.length() && j<b.length()){
            if(a.charAt(i)==b.charAt(j)){
                i++;
            }
            j++;
        }

        return i==a.length();
        
    }
    public int findLUSlength(String[] strs) {
        int maxlen=-1;
        for(int i=0;i<strs.length;i++){
            boolean uncommon = true;
            for(int j=0;j<strs.length;j++){
                if(i==j){
                    continue;
                }
                if(issubsequence(strs[i],strs[j])){
                    uncommon=false;
                    break;
                }
            }

            if(uncommon){
                maxlen=Math.max(maxlen,strs[i].length());
            }
        }

        return maxlen;
        
    }
}