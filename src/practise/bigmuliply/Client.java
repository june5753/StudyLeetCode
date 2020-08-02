package practise.bigmuliply;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by yangjun on 2020/4/13.
 */
public class Client {

    public static void main(String[] args) {

        //如果用java的封装类实现
        BigInteger big1 = new BigInteger("-8889");
        BigInteger big2 = new BigInteger("7");
        BigInteger bigMul = big1.multiply(big2);
        System.out.println("相乘的结果为" + bigMul);


        //方法一：
//        LargeNumberOperation largeNumberOperation = new LargeNumberOperation();
//
//        String result = largeNumberOperation.operation("-123", 5);
//
//
//        System.out.print("相乘的结果为" + result);

        //TODO 方法二：
        String num1 = "-8889";
        String b = "7";
        String a;

        //判断是否为正数
        if (num1.charAt(0) == '-') {
            a = num1.substring(1);
            System.out.println("是负数，此时a==" + a);
        } else {
            a = num1;
            System.out.println("是正数");
        }

        char[] charArr1 = a.trim().toCharArray();
        char[] charArr2 = b.trim().toCharArray();


        // 字符数组转换为int[]数组
        int[] arr1 = new int[charArr1.length];
        int[] arr2 = new int[charArr2.length];
        for (int i = 0; i < charArr1.length; i++) {
            arr1[i] = charArr1[i] - '0';
        }
        for (int i = 0; i < charArr2.length; i++) {
            arr2[i] = charArr2[i] - '0';
        }

        // 开始计算
        int[] result = bigNumberMultiply2(arr1, arr2);

        String replace = Arrays.toString(result).replace(", ", "");

        //添加正负数号
        String lastResult;

        if (num1.charAt(0) == '-') {
            lastResult = new StringBuilder("-").append(replace).toString();
        } else {
            lastResult = replace;
        }

        System.out.println(a + " * " + b + " = " + lastResult);

    }

    public static int[] bigNumberMultiply2(int[] num1, int[] num2) {
        // 分配一个空间，用来存储运算的结果，num1长的数 * num2长的数，结果不会超过num1+num2长
        int[] result = new int[num1.length + num2.length];

        // 先不考虑进位问题，根据竖式的乘法运算，num1的第i位与num2的第j位相乘，结果应该存放在结果的第i+j位上
        for (int i = 0; i < num1.length; i++) {
            for (int j = 0; j < num2.length; j++) {
                result[i + j + 1] += num1[i] * num2[j];     // (因为进位的问题，最终放置到第i+j+1位)
            }
        }

        //单独处理进位
        for (int k = result.length - 1; k > 0; k--) {
            if (result[k] > 10) {
                result[k - 1] += result[k] / 10;
                result[k] %= 10;
            }
        }
        return result;
    }
}
