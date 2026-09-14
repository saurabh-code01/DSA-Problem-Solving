class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        
        // Iterate from MSB (31) to LSB (0)
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i); // include current bit in mask
            HashSet<Integer> set = new HashSet<>();
            
            // Store prefixes with current mask
            for (int num : nums) {
                set.add(num & mask);
            }
            
            // Candidate with current bit set
            int candidate = max | (1 << i);
            
            // Check if candidate achievable
            for (int prefix : set) {
                if (set.contains(prefix ^ candidate)) {
                    max = candidate;
                    break;
                }
            }
        }
        return max;
    }
}
