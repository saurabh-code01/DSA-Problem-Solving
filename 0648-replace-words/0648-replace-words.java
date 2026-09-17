class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] sent=sentence.split(" ");
        for(int i=0;i<dictionary.size();i++){
            int n=dictionary.get(i).length();
            
            for(int j=0;j<sent.length;j++){
                boolean isroot=true;
                if(sent[j].length()>=n){
                    int k=0;
                    while(k<n){
                        if(dictionary.get(i).charAt(k)!=sent[j].charAt(k)){
                            isroot=false;
                            break;
                        }
                        k++;
                    
                    }if(isroot){
                        sent[j]=dictionary.get(i);
                    }
                }
            }

        } 

        return String.join(" ",sent);
        
    }
}