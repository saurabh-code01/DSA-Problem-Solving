class Solution {
    public int findJudge(int n, int[][] trust) {
        HashSet<Integer> set=new HashSet<>();
        for(int i=1;i<=n;i++){
            set.add(i);
        }
        for(int i=0;i<trust.length;i++){    //condition first town judje trusts nobody
            if(set.contains(trust[i][0])){
                set.remove(trust[i][0]);
            }
        }

        if(set.isEmpty()){
            return -1;
        }
        
        
        int prejudge=set.iterator().next();
        int votecount=0;
        for(int i=0;i<trust.length;i++){
            if(prejudge==trust[i][1]){
                votecount++;
            }
        }

        if(votecount==n-1){
            return prejudge;
        }

        return -1;
        
    }
}