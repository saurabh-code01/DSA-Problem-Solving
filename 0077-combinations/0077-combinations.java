class Solution {
    private static void backtrack(int k,int n,List<List<Integer>> result,List<Integer> sublist,int i){
        if(k==0){  //base case
            result.add(new ArrayList<>(sublist));
            return ;
        }

        if(i>n){
            return ;
        }

        //choice 1
        sublist.add(i);
        backtrack(k-1,n,result,sublist,i+1);
        sublist.remove(sublist.size()-1);// backtrack

        //choice 2
        backtrack(k,n,result,sublist,i+1);
        
        
        

    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer>sublist=new ArrayList<>();
        backtrack(k,n,result,sublist,1);

        return result;

        
    }
}