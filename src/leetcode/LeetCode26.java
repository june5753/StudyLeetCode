package leetcode;

/**
 * 26. 删除排序数组中的重复项
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class LeetCode26 {

    /**
     * 测试类
     *
     * @param args
     */
    public static void main(String[] args) {

        LeetCode26 leetCode26 = new LeetCode26();

        int[] nums = new int[]{1, 1, 2};
        int[] nums1 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        System.err.println(leetCode26.removeDuplicates(nums1));

    }

    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) return 0;
        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

}
