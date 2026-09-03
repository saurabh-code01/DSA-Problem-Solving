class Solution {
    public String getHint(String secret, String guess) {
        int bull=0;
        int cat=0;
        StringBuilder sb=new StringBuilder();
        HashMap<Character,Integer>secretmap=new HashMap<>();
        HashMap<Character,Integer>guessmap=new HashMap<>();
        for(int i=0;i<guess.length();i++){
            if(guess.charAt(i)==secret.charAt(i)){
                bull++;
            }else{
                secretmap.put(secret.charAt(i),secretmap.getOrDefault(secret.charAt(i),0)+1);
                guessmap.put(guess.charAt(i),guessmap.getOrDefault(guess.charAt(i),0)+1);
            }
        }

        for(int i=0;i<guess.length();i++){
            if(secretmap.containsKey(guess.charAt(i)) && guessmap.containsKey(guess.charAt(i))){
                cat+=Math.min(secretmap.get(guess.charAt(i)),guessmap.get(guess.charAt(i)));
                secretmap.remove(guess.charAt(i));
            }
        }

        sb.append(bull);
        sb.append('A');
        sb.append(cat);
        sb.append('B');

        return sb.toString();
    
    }
}