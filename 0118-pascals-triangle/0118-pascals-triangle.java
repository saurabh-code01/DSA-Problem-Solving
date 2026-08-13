class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>result=new ArrayList<>();
        List<Integer>firstrow=new ArrayList<>();
        firstrow.add(1);
        result.add(firstrow);
        if(numRows==1){
            return result;
        }
        for(int i=1;i<numRows;i++){
            List<Integer>prev=result.get(i-1);
            
            List<Integer>currow=new ArrayList<>();
            currow.add(1);
            for(int j=0;j<i-1;j++){
                currow.add(prev.get(j)+prev.get(j+1));
            }
            currow.add(1);

            result.add(currow);

        }

        return result;
        
    }
}