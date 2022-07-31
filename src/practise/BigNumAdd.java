package practise;

/**
 * <pre>
 *     author : June Yang
 *     time   : 2022/07/25
 *     desc   : 两个大数相加
 *     version: 1.0
 * </pre>
 */
public class BigNumAdd {
    public static void main(String[] args) {
        System.out.println(bigNumberNum("6868", "128080989089093"));
    }
    public static String bigNumberNum(String bigNumberA, String bigNumBerB) {
        int maxLength = Math.max(bigNumberA.length(), bigNumBerB.length());
        int[] arrayA = new int[maxLength + 1];
        // 将 String 转化成 int
        for (int i = 0; i < bigNumberA.length(); i++) {
            arrayA[i] = bigNumberA.charAt(bigNumberA.length() - 1 - i) - '0';
        }
        int[] arrayB = new int[maxLength + 1];
        // 将 String 转化成 int
        for (int i = 0; i < bigNumBerB.length(); i++) {
            arrayB[i] = bigNumBerB.charAt(bigNumBerB.length() - 1 - i) - '0';
        }
        // 得到结果的数组
        int[] result = new int[maxLength + 1];

        // 核心算法：竖式相加 满 10 进 1
        for (int i = 0; i < result.length; i++) {
            int temp = result[i];
            temp += arrayA[i];
            temp += arrayB[i];

            if (temp >= 10) {
                temp = temp - 10;
                result[i + 1] = 1; // 将进位后的 1 存到数组的下一位
            }
            result[i] = temp;
        }
        // 将 result 数组倒序之后再转成 String
        StringBuilder sb = new StringBuilder();
        boolean findFist = false;
        for (int i = result.length - 1; i >= 0; i--) {
            if (!findFist) {
                if (result[i] == 0) {
                    continue;  // continue 的作用：跳过当前循环继续下一个循环。此处 用于跳过结果数组末尾的 "0"
                }
                findFist = true;
            }
            sb.append(result[i]);
        }
        return sb.toString();
    }
}