package sort;

import java.util.Arrays;

/**
 * <pre>
 *     author : June Yang
 *     time   : 2022/07/31
 *     desc   :  快速排序
 *     基本思想：
 *     1. 选定 pivot 中的基准元素
 *     2. 将大于 pivot 的放在另边
 *     3. 将小于 pivot 的放在左边
 *     4. 分别对左右子序列重复上面三个步骤
 *     version: 1.0
 * </pre>
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{90, 1, 3, 4, 4, 6, 9, 0};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        // 得到基准元素位置
        int provotIndex = partition(arr, startIndex, endIndex);
        quickSort(arr, startIndex, provotIndex - 1);
        quickSort(arr, provotIndex + 1, endIndex);
    }

    /**
     * 实现元素的交换，让数列中的元素分别交换到基准元素的两边
     */
    private static int partition(int[] arr, int startIndex, int endIndex) {
        // 选取第一个元素为基准元素
        int pivotIndex = arr[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left != right) {
            // 控制 right 指针比较并左移
            while (left < right && arr[right] > pivotIndex) {
                right--;
            }
            // 控制 left 指针比较并右移
            while (left < right && arr[left] <= pivotIndex) {
                left++;
            }
            // 交换 left 和 right 指针所指向的元素
            if (left < right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }
        // pivot和指针重合点交换
        arr[startIndex] = arr[left];
        arr[left] = pivotIndex;
        return left;
    }
}
