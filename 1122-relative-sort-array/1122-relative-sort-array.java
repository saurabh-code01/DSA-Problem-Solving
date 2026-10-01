class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int []arr=new int[arr1.length];

        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int i=0;i<arr1.length;i++){
            map.put(arr1[i],map.getOrDefault(arr1[i],0)+1);
        }
        int idx=0;
        for(int i=0;i<arr2.length;i++){
            int num=arr2[i];
            int j=idx;
            int count=idx+map.get(num);
            while(j<count){
                arr[j]=num;
                j++;
            }
            map.remove(num);
            idx=j;
        }

        if(!map.isEmpty()){
            for(Map.Entry<Integer,Integer> entry:map.entrySet()){
                int key=entry.getKey();
                int count=entry.getValue();
                for(int i=0;i<count;i++){
                    arr[idx]=key;
                    idx++;
                }
            }    
        }
        return arr;

    }
}