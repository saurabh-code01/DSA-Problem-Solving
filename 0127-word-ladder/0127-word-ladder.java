/*class Solution {
    public int ladderLength(String beginword, String endword, List<String> wordList) {
        Queue<String> queue=new LinkedList<>();
        queue.add(beginword);
        queue.add(null);

        Set<String> visited=new HashSet<>();
        visited.add(beginword);

        int level=1;
        while(!queue.isEmpty()){
            String word=queue.poll();

            if(word == null){
                level++;
                if(!queue.isEmpty()){
                    queue.add(null);
                }
                continue;
            }

            if(word.equals(endword)){
                return level;
            }

            for(int i=0;i<word.length();i++){
                char[] chars=word.toCharArray();
                for(char c='a';c<='z';c++){
                    chars[i]=c;
                    String nextword=new String(chars);

                    if(wordList.contains(nextword) && !visited.contains(nextword)){
                        visited.add(nextword);
                        queue.offer(nextword);
                    }

                }

            }

        }
        return 0;
        
    }
}*/
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        queue.add(null);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            String word = queue.poll();

            if (word == null) {
                level++;
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
                continue;
            }

            if (word.equals(endWord)) {
                return level;
            }

            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char original = chars[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == original) continue; // skip same char
                    chars[i] = c;
                    String nextWord = new String(chars);

                    if (wordSet.contains(nextWord) && !visited.contains(nextWord)) {
                        visited.add(nextWord);
                        queue.offer(nextWord);
                    }
                }
                chars[i] = original; // restore
            }
        }
        return 0;
    }
}
