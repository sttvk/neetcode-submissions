class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        
        if (len1 > len2) return false;
        
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        for (int i = 0; i < len1; i++) {
            s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < len2 - len1; i++) {
            if (Arrays.equals(s1Map, s2Map)) {
                return true;
            }

            s2Map[s2.charAt(i) - 'a']--;
            s2Map[s2.charAt(i + len1) - 'a']++;
        }

        return Arrays.equals(s1Map, s2Map);
    }
}
