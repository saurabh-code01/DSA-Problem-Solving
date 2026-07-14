class Solution {
    public int magicalString(int n) {
        int count=0;
        if(n<=3){
            return 1;
        }
        StringBuilder sb=new StringBuilder("122");
        int m=sb.length()-1;
        for(int i=m;sb.length()<n;i++){
            if(sb.charAt(i)=='2'){
                char next=sb.charAt(sb.length()-1)=='1'?'2':'1';
                sb.append(next).append(next);
                
            }
            if(sb.charAt(i)=='1'){
                char next=sb.charAt(sb.length()-1)=='1'?'2':'1';
                sb.append(next);
            }
        }
        for(int i=0;i<n;i++){
            if(sb.charAt(i)=='1'){
                count++;
            }
        }
        return count;
        
        

         
        
    }
}