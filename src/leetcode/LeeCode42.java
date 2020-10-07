package leetcode;

import java.util.Deque;
import java.util.LinkedList;

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
//        int res = leeCode42.trap1(height);
//        int res = leeCode42.trap2(height);
        int res = leeCode42.trap4(height);
        System.out.println(res);
    }

    //暴力解法：找到两边最高的那个高度，还要减去自己的高度
    public int trap1(int[] height) {

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

    /**
     * 这种方法最简单，最容易默写出来
     * 对于数组中的每个元素，我们找出下雨后水能达到的最高位置，等于两边最大高度的较小值减去当前高度的值。
     * 复杂性分析:
     * 时间复杂度： O(n^2))。数组中的每个元素都需要向左向右扫描。
     * 空间复杂度 O(1) 的额外空间。
     */

    public int trap2(int[] height) {
        int ans = 0;
        int size = height.length;

        for (int i = 0; i < size - 1; i++) {
            int max_left = 0, max_right = 0;

            for (int j = i; j >= 0; j--) {
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i; j < size - 1; j++) {
                max_right = Math.max(max_right, height[j]);
            }
            ans += Math.min(max_right, max_left) - height[i];
        }
        return ans;
    }

    /**
     * 算法：
     * 我们在遍历数组时维护一个栈。如果当前的条形块小于或等于栈顶的条形块，我们将条形块的索引入栈，意思是当前的条形块被栈中的前一个条形块界定。
     * 如果我们发现一个条形块长于栈顶，我们可以确定栈顶的条形块被当前条形块和栈的前一个条形块界定，
     * 因此我们可以弹出栈顶元素并且累加答案到 ans.
     * <p>
     * 复杂性分析:
     * 时间复杂度：O(n)
     * 单次遍历 O(n)，每个条形块最多访问两次（由于栈的弹入和弹出），并且弹入和弹出栈都是 O(1) 的。
     * 空间复杂度：O(n)栈最多在阶梯型或平坦型条形块结构中占用 O(n)的空间。
     */
    public int trap3(int[] height) {
        int ans = 0, current = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) break;

                int distance = current - stack.peek() - 1;
                int bound_height = Math.min(height[current], height[stack.peek()]) - height[top];
                ans += distance * bound_height;
            }
            stack.push(current++);
        }

        return ans;
    }

    /**
     * 方法 4：使用双指针 （重要的方法，需要记住默写）
     * 直观想法
     * 我们不从左和从右分开计算，我们想办法一次完成遍历。
     * 从动态编程方法的示意图中我们注意到，只要 right_max[i]>left_max[i] （元素 0 到元素 6），
     * 积水高度将由 left_max 决定，类似地left_max[i]>right_max[i]（元素 8 到元素 11）。
     * 所以我们可以认为如果一端有更高的条形块（例如右端），积水的高度依赖于当前方向的高度（从左到右）。当我们发现另一侧（右侧）的条形块高度不是最高的，
     * 我们则开始从相反的方向遍历（从右到左）。
     * 我们必须在遍历时维护 left_max和right_max但是我们现在可以使用两个指针交替进行，实现 1 次遍历即可完成。
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int trap4(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int left = 0, right = height.length - 1;
        int ans = 0;

//        int left_max = 0, right_max = 0; //初始化可以都为0，也可以用下面的实现

        int left_max = height[0];
        int right_max = height[height.length - 1];


        while (left < right) {

            if (height[left] < height[right]) {
                if (height[left] >= left_max) { //注意从左更新条件
                    left_max = height[left];
                } else {
                    ans += (left_max - height[left]);
                }
                ++left; //left++ 亦可
            } else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    ans += (right_max - height[right]);
                }
                --right; //right-- 亦可
            }
        }
        return ans;
    }

}
