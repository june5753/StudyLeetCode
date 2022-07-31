package leetcode;

/**
 * <pre>
 *     author : June Yang
 *     time   : 2020/10/19
 *     desc   :
 *     字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 *     比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。
 *     你可以假设字符串中只包含大小写英文字母（a至z）。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/compress-string-lcci
 *     version: 1.0
 * </pre>
 */
public class LeeCode0106 {
    public static void main(String[] args) {
        String s1 = "aabcccccaa"; //a2b1c5a2
        String s2 = "abbccd";//a1b2c2d1
        LeeCode0106 leeCode0106 = new LeeCode0106();
        System.out.println(leeCode0106.compressString(s1));
        System.out.println(leeCode0106.compressString(s2));
    }

    public String compressString(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        StringBuilder sb = new StringBuilder().append(s.charAt(0));
        int number = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                number++;
            } else {
                sb.append(number).append(s.charAt(i));
                number = 1;
            }
        }
        return sb.append(number).toString();
//        return sb.append(number).length() < s.length() ? sb.toString() : s;
    }
}
