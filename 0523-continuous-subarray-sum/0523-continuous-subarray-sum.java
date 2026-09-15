import java.util.HashMap;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // HashMap to store remainder and its first index
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // important fix: handle prefix sum divisible by k

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = sum % k;

            // normalize remainder for negative values
            if (remainder < 0) {
                remainder += k;
            }

            if (map.containsKey(remainder)) {
                int prevIndex = map.get(remainder);
                if (i - prevIndex >= 2) {
                    return true; // subarray length >= 2 found
                }
            } else {
                map.put(remainder, i); // store first occurrence
            }
        }
        return false;
    }
}
