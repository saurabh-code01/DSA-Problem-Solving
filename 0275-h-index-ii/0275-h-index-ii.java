class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        for(int i=0;i<n;i++){
            int quality=citations[i];
            int quantity=n-i;
            if(quantity<=quality){
                return quantity;
            }

        }
        return citations[0];
        
    }
}