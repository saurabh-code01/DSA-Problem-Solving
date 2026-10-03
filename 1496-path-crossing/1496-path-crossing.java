class Solution {
    public boolean isPathCrossing(String path) {
        HashSet<String> set=new HashSet<>();
        int x=0,y=0;
        set.add(x+","+y);
        for(int i=0;i<path.length();i++){
            if(path.charAt(i)=='N'){
                x+=1;
            }
            else if(path.charAt(i)=='S'){
                x-=1;

            }else if(path.charAt(i)=='W'){
                y-=1;

            }else{
                y+=1;;

            }
            String currdir=x+","+y;
            if(set.contains(currdir)){
                return true;
            }
            set.add(currdir);
            
        }

        return false;
        
        
    }
}