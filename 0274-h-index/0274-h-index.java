class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n=citations.length;
        int low=0,high=n-1;
        int quality=0,quantity=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            quality=citations[mid];
            quantity=n-mid;
            if(quality>=quantity){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }

        return n-low;
    }
}