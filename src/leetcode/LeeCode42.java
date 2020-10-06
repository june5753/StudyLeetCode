package leetcode;

/**
 * <pre>
 *     author : June Yang
 *     time   : 2020/10/06
 *     42. 接雨水
 *     desc   :https://leetcode-cn.com/problems/trapping-rain-water/
 *     参考题解：https://leetcode-cn.com/problems/trapping-rain-water/solution/bao-li-jie-fa-yi-kong-jian-huan-shi-jian-zhi-zhen-/
 *     version: 1.0
 * </pre>
 */
public class LeeCode42 {
    public static void main(String[] args) {
        LeeCode42 leeCode42 = new LeeCode42();
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int res = leeCode42.trap(height);
        System.out.println(res);
    }

    //暴力解法：找到两边最高的那个高度，还要减去自己的高度
    public int trap(int[] height) {

        int len = height.length;

        if (len < 3) {
            return 0;
        }

        int res = 0;

        // 对区间 [1, len - 2] 的每个位置，分别计算可以存水的单位体积
        for (int i = 1; i < len - 1; i++) {
            int leftHighest = max(height, 0, i - 1);
            int rightHighest = max(height, i + 1, len - 1);

            //木桶原理，存水的高度取决于二者之中最低的
            int curHeight = Math.min(leftHighest, rightHighest);

            if (curHeight > height[i]) {
                res += (curHeight - height[i]);
            }
        }
        return res;
    }

    private int max(int[] height, int left, int right) {
        int res = height[left];
        for (int i = left + 1; i <= right; i++) {
            res = Math.max(res, height[i]);
        }
        return res;
    }
}
