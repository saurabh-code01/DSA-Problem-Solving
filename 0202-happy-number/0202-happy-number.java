class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer>seen=new HashSet<>();
        while(n!=1 && !seen.contains(n)){
            seen.add(n);
            int sum=0;
            while(n>0){
                int num=n%10;
                sum=sum+(num*num);
                n=n/10;
            }
            n=sum;
        }
        return n==1;
        
    }
}