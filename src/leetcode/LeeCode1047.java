package leetcode;

import java.util.Stack;

/**
 * <pre>
 *     author : June Yang
 *     time   : 2020/10/05
 *     1047. 删除字符串中的所有相邻重复项
 *     desc   :https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 *     version: 1.0
 * </pre>
 */
public class LeeCode1047 {
    public static void main(String[] args) {
        LeeCode1047 leeCode1047 = new LeeCode1047();
        String str = leeCode1047.removeDuplicates("abbaca");
        System.out.println(str);
    }

    public String removeDuplicates(String str) {
//        char[] s = str.toCharArray();
//        int len = s.length;
        int len = str.length();

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < len; i++) {
            if (stack.isEmpty() || str.charAt(i) != stack.peek()) {
                stack.push(str.charAt(i));
            } else {
                stack.pop();
            }
        }
        StringBuilder result = new StringBuilder();
        for (Character c : stack) {
            result.append(c);
        }
        return result.toString();
    }
}
/**
 *  解题思路
 * 简单的利用栈的性质
 * 定义一个栈
 * 遍历S，如果栈为空或该字符不等于栈顶元素
 * 则入栈，如果该字符等于栈顶元素
 * 则将栈顶元素出栈
 * 定义result，将操作后的栈以字符串的形式输出
 */
