package leetcode;

/**
 * <pre>
 *     author : June Yang
 *     time   : 2020/08/10
 *     desc   : 最长回文子串
 *     给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *     https://leetcode-cn.com/problems/longest-palindromic-substring/
 *     version: 1.0
 * </pre>
 */
public class LeetCode05 {

    public static void main(String[] args) {

        LeetCode05 lee = new LeetCode05();

        String str = lee.longestPalindrome("add6909000000008");
        System.out.println(str);

    }

    public String longestPalindrome(String s) {
        int len = s.length();

        if (len < 2) return s;

        int maxLen = 1;
        int begin = 0;

        // s.charAt(i) 每次都会检查数组下标越界，因此先转换成字符数组
        char[] charArray = s.toCharArray();

        // 枚举所有长度大于 1 的子串 charArray[i..j]
        for (int i = 0; i < len - 1; i++) {

            for (int j = i + 1; j < len; j++) {

                if (j - i + 1 > maxLen && isPalindrome(charArray, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }

        }

        return s.substring(begin, begin + maxLen);

    }

    /**
     * 判断是否是回文串
     * 验证子串 s[left..right] 是否为回文串
     *
     * @param charArray
     * @param left
     * @param right
     * @return
     */
    private boolean isPalindrome(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
