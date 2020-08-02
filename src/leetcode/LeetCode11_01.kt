package leetcode

object LeetCode11_01 {

    @JvmStatic
    fun main(args: Array<String>) {
        val nums = intArrayOf(1, 9, 6, 2, 5, 4, 7)
        println(maxArea(nums))
    }

    /**
     * 盛水最多的容器 双指针法
     *
     * @param height
     * @return
     */
    fun maxArea(height: IntArray): Int {
        var res = 0
        var i = 0
        var j = height.size - 1
        while (i < j) {
            val area = (j - i) * height[i].coerceAtMost(height[j])
            res = res.coerceAtLeast(area)
            if (height[i] < height[j]) {
                i++
            } else {
                j--
            }
        }
        return res
    }
}