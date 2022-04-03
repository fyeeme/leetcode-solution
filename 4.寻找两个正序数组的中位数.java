/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 *
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (41.22%)
 * Likes:    5250
 * Dislikes: 0
 * Total Accepted:    662.7K
 * Total Submissions: 1.6M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 *
 * 示例 2：
 *
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 *
 *
 *
 *
 *
 * 提示：
 *
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 *
 *
 */
// 145 2

// @lc code=start
class Solution {
    // 寻找两个正序数组的中位数
    /**
     * * Find the median by traversing.
     * *
     * * Time complexity: O(m+n). Although the running time is similar, it is worse
     * than the required O(log (m+n)).
     * * Space complexity: O(1).
     * *
     * * @param nums1 the first sorted arrays
     * * @param nums2 the second sorted arrays
     * * @return the median of the two sorted arrays
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 找到中位数的位置,满足 左边的所有元素小于等于右边的所有元素
        int middle = (nums1.length + nums2.length) / 2;
        int index1 = 0, index2 = 0, med1 = 0, med2 = 0;

        for (int i = 0; i <= middle; i++) {
            med1 = med2;
            // 第一个数组为空, 从第二个数组开始
            if (index1 == nums1.length) {
                med2 = nums2[index2];
                index2++;
            } else if (index2 == nums2.length) {
                // 第二个数组为空，从第一个数组开始
                med2 = nums1[index1];
                index1++;
                // 如果从第一个数组找到目标下标，则不会执行其他判断
            } else if (nums1[index1] < nums2[index2]) {
                med2 = nums1[index1];
                index1++;
                // 找完第一个数组元素，继续找第二个数组的元素
            } else {
                med2 = nums2[index2];
                index2++;
            }
        }
        if ((nums1.length + nums2.length) % 2 == 0) {
            return (float) (med1 + med2) / 2;
        }
        return med2;
    }
}
// @lc code=end
