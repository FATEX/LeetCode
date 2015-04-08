/*
 * Manacher’s Algorithm
 */
public class LongestPalindromicSubstring {
	
	public String longestPalindrome(String s) {
        String t = preProcess(s);
        int length = t.length();
        int[] p = new int[length];
        int center = 0;
        int right = 0;
        for (int i = 1; i < length - 1; i++) {
            int sym = center - (i - center);
            p[i] = right > center ? Math.min(right - i, p[i]) : 0;
            while (t.charAt(i + p[i] + 1) == t.charAt(i - p[i] - 1)) p[i]++;
            if (i + p[i] > right) {
                center = i;
                right = p[i] + i;
            }
        }
        
        int maxLength = 0;
        int centerIndex = 0;
        for (int j = 0; j < p.length; j++) {
            if (maxLength < p[j]) {
                maxLength = p[j];
                centerIndex = j;
            }
        }
        int startIndex = (centerIndex - 1 - maxLength)/2;
        return s.substring(startIndex, startIndex + maxLength);
    }
    
    private String preProcess(String s) {
        StringBuilder result = new StringBuilder("^");
        for (int i = 0; i < s.length(); i++) {
            result.append('#');
            result.append(s.charAt(i));
        }
        result.append("#$");
        return result.toString();
    }

	public static void main(String[] args) {
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		lps.longestPalindrome("abcbca");

	}

}
