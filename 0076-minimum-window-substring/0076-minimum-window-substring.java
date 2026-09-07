class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        if (t.length() > n) return "";

        // creating map
        HashMap<Character, Integer> mp = new HashMap<>();
        for (char ch : t.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        int requdcount = t.length();
        int i = 0, j = 0;
        int windsize = Integer.MAX_VALUE;
        int start_i = 0;

        while (j < n) {
            char ch = s.charAt(j);
            mp.put(ch, mp.getOrDefault(ch, 0) - 1);
            if (mp.get(ch) >= 0) {
                requdcount--;
            }

            while (requdcount == 0) {
                int currwindsize = j - i + 1;
                if (currwindsize < windsize) {
                    windsize = currwindsize;
                    start_i = i;
                }

                char c = s.charAt(i);
                mp.put(c, mp.getOrDefault(c, 0) + 1);
                if (mp.get(c) > 0) {
                    requdcount++;
                }
                i++;
            }
            j++;
        }
        return windsize == Integer.MAX_VALUE ? "" : s.substring(start_i, start_i + windsize);
            
        
    }
}