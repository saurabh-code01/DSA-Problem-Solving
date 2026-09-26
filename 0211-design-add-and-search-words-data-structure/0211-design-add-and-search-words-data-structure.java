/*class WordDictionary {
    private HashSet <String> set;

    public WordDictionary() {
        set=new HashSet<>();
        
    }
    
    public void addWord(String word) {
        set.add(word);
        
    }
    
    public boolean search(String word) {
        int n=word.length();
        for(String str:set){
            boolean match=true;
            if(str.length()!=n){
                continue;
            }

                
            for(int i=0;i<n;i++){
                if(word.charAt(i)=='.'){
                    continue ;
                }
                if(word.charAt(i)!=str.charAt(i)){
                    match=false;
                    break;
                }

            }
            if(match){
                return true;
            }
            
        }
        

        return false;
        
    }
}*/
class WordDictionary {
    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }

    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node) {
        if (node == null) return false;
        if (index == word.length()) return node.isEndOfWord;

        char c = word.charAt(index);
        
        if (c == '.') {
            // Wildcard: explore all existing non-null branches
            for (TrieNode child : node.children) {
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            int childIndex = c - 'a';
            return dfs(word, index + 1, node.children[childIndex]);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */