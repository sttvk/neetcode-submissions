class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int maxLen = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (window.contains(c)) {
                window.remove(s.charAt(start));
                start++;
            } 
                
            window.add(c);
            maxLen = Math.max(maxLen, window.size());
        }

        return maxLen;        
    }
}
