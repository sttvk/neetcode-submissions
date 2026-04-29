public class Solution {
    public bool IsPalindrome(string s) {
        var li = 0;
        var ri = s.Length - 1;

        while (li < ri) {
            while (li < ri && !Char.IsLetterOrDigit(s[li])) {
                li++;
            }

            while (li < ri && !Char.IsLetterOrDigit(s[ri])) {
                ri--;
            }

            if (Char.ToLower(s[li]) != Char.ToLower(s[ri])) {
                return false;
            } 

            li++;
            ri--;
        }

        return true;
    }
}
