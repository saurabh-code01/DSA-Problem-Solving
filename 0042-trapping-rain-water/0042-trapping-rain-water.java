class Solution {
    public int trap(int[] height) {
        int total=0;
        int width=1;
        // making leftmax prefix array
        int leftmaxarr[]=new int[height.length];
        leftmaxarr[0]=height[0];
        for(int i=1;i<height.length;i++){
            leftmaxarr[i]=Math.max(leftmaxarr[i-1],height[i]);
        }
         
        // making rightmax prefix array
        int rightmaxarr[]=new int[height.length];
        rightmaxarr[height.length-1]=height[height.length-1];
        for(int i=height.length-2;i>=0;i--){
            rightmaxarr[i]=Math.max(rightmaxarr[i+1],height[i]);
        }
        for(int i=0;i<height.length;i++){
            int wth=Math.min(leftmaxarr[i],rightmaxarr[i]);
            int count=(wth-height[i])*width;
            total+=count;
            
        }
        return total;

    }
}