package leetcode;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class LeetCode11 {

    public static void main(String[] args) {

        int[] nums = new int[]{2, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(nums));

    }

    /**
     * 盛水最多的容器 双指针法
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int res = 0;
        int i = 0;
        int j = height.length - 1;

        while (i < j) {

            int area = (j - i) * Math.min(height[i], height[j]);

            res = Math.max(res, area);

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }

        }


        return res;

    }
}
