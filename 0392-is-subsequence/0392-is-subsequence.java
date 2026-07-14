class Solution {
    public boolean isSubsequence(String s, String t) {
        int n=s.length()-1;
        Stack<Character> st=new Stack<>();
        for (int i=0;i<t.length();i++){
            st.push(t.charAt(i));
        }
        while(!st.isEmpty() && n>=0){
            if(s.charAt(n)==st.peek()){
                n--;
            }
            st.pop();
        }

        return n<0?true:false;

        
    }
}