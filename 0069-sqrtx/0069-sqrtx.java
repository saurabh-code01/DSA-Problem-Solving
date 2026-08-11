class Solution {
    public int mySqrt(int x) {
        if(x<2){
            return x;
        }
        int st=1,ei=x/2;
        int ans=0;
        while(st<=ei){
            int mid=st+(ei-st)/2;
            long sq=(long)mid*mid;
            if(sq==x){
                return mid;
            }
            else if(sq>x){
                ei=mid-1;
            }
            else{
                ans=mid;
                st=mid+1;
            }
        }
        return ans;
        
    }
}