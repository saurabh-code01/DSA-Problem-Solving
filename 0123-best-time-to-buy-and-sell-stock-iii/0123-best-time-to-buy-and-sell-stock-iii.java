class Solution {
    public int maxProfit(int[] prices) {
        int[]ltor=new int[prices.length];
        int[]rtol=new int[prices.length];
        int[]arr=new int[prices.length];
        if(prices.length<2){
            return 0;
        }
        int maxprofit=Integer.MIN_VALUE;
        int minprice=Integer.MAX_VALUE;


        for(int i=0;i<prices.length;i++){          // left to right 
            minprice=Math.min(minprice,prices[i]);
            maxprofit=Math.max(maxprofit,prices[i]-minprice);
            if(maxprofit<0){
                maxprofit=0;
            }
            ltor[i]=maxprofit;

        }

        int maxprice=prices[prices.length-1];
        int maxprofit1=Integer.MIN_VALUE;

        for(int i=prices.length-1;i>=0;i--){
            maxprice=Math.max(maxprice,prices[i]);
            maxprofit1=Math.max(maxprofit1,maxprice-prices[i]);
            if(maxprofit1<0){
                maxprofit1=0;
            }
            rtol[i]=maxprofit1;

        }

        for(int i=0;i<prices.length;i++){
            arr[i]=ltor[i]+rtol[i];

        }
        Arrays.sort(arr);
        return arr[prices.length-1];
        
    }
}