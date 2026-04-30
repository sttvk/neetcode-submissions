class Solution {
    public boolean isPalindrome(String s) {
        int li = 0;
        int ri = s.length() - 1;

        while (li < ri) {
            if (!Character.isLetterOrDigit(s.charAt(li))) {
                li++;
            } else if (!Character.isLetterOrDigit(s.charAt(ri))) {
                ri--;
            } else {
                if (Character.toLowerCase(s.charAt(li)) != Character.toLowerCase(s.charAt(ri))) {
                    return false;  
                }

                li++;
                ri--;
            }
        }

        return true;
    }
}
