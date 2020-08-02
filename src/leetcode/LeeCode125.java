package leetcode;

/**
 *验证回文串
 * @link https://leetcode-cn.com/problems/valid-palindrome/
 */
public class LeeCode125 {


    public static void main(String[] args) {

        LeeCode125 leeCode =new LeeCode125();
        System.out.println(leeCode.isPalindrome("a"));

    }


    public  boolean isPalindrome(String s) {

        //判断一个字符串是否回文串
        String mStr = s.toUpperCase();

        char[] chars = mStr.toCharArray();

        int left = 0, right = chars.length - 1;

        while (left <= right) {
            //判断是否是数字或字母
            if (Character.isLetterOrDigit(chars[left]) && Character.isLetterOrDigit(chars[right])) {

                if (chars[left] != chars[right]) {
                    return false;
                }
                ++left;
                --right;

            }
            if (!Character.isLetterOrDigit(chars[left])) {
                ++left;
            }

            if (!Character.isLetterOrDigit(chars[right])) {
                --right;
            }

        }
        return true;

    }
}
