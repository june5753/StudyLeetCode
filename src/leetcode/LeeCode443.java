package leetcode;

/**
 * <pre>
 *     author : June Yang
 *     time   : 2020/10/19
 *     desc   :给定一组字符，使用原地算法将其压缩。
 * 压缩后的长度必须始终小于或等于原数组长度。
 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
 * 在完成原地修改输入数组后，返回数组的新长度。
 * 链接：https://leetcode-cn.com/problems/string-compression
 *     version: 1.0
 * </pre>
 */
public class LeeCode443 {
    public static void main(String[] args) {
        LeeCode443 leeCode443 = new LeeCode443();

        char[] chars = "aabbccc".toCharArray();
        char[] chars2 = "abbbbbbbbbbbb".toCharArray();
        System.out.println(leeCode443.compress(chars));
        System.out.println(leeCode443.compress(chars2));
    }

    public int compress(char[] chars) {
        int left = 0;
        int size = 0;

        // 由于最后一个字符也需要判断，所以将右指针终点放到数组之外一格
        for (int right = 0; right <= chars.length; right++) {
            // 当遍历完成，或右指针元素不等于左指针元素时，更新数组
            if (right == chars.length || chars[right] != chars[left]) {
                chars[size++] = chars[left]; // 更新字符
                if (right - left > 1) {// 更新计数，当个数大于 1 时才更新
                    for (char c : String.valueOf(right - left).toCharArray()) {
                        chars[size++] = c;
                    }
                }
                left = right;
            }
        }
        return size;
    }
}
