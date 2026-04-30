class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int maxLen = 0;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            while (window.contains(s.charAt(r))) {
                window.remove(s.charAt(l));
                l++;
            }

            window.add(s.charAt(r));
            maxLen = Math.max(maxLen, window.size());
        }

        return maxLen;
    }
}
