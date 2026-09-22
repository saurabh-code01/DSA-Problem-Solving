class TopVotedCandidate {
    private int[] times;
    private int[] leaders;

    public TopVotedCandidate(int[] persons, int[] times) {
        leaders=new int[persons.length];
        this.times=times;

        HashMap<Integer,Integer> map=new HashMap<>();
        int leader=-1;
        for(int i=0;i<persons.length;i++){
            map.put(persons[i],map.getOrDefault(persons[i],0)+1);

            if(leader==-1 || map.get(persons[i])>=map.get(leader)){
                leader=persons[i];
            }
            leaders[i]=leader;
        }

    }
    
    public int q(int t) {
        int l=0,r=times.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(times[mid]<=t){
                l=mid+1;
            
            }
            else{
                r=mid-1;
            }
        }    

        return leaders[r];
    }
        
    
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */