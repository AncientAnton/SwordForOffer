/**
 * Author: AncientAnton
 * Date: 2018/7/30.
 * Description:
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 * 你可以假设 nums1 和 nums2 均不为空。
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 中位数是 2.0
 *
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 中位数是 (2 + 3)/2 = 2.5
 *
 * 参考答案是采用二分查找的方式，但我感觉太复杂了。
 *
 * 我用的是两个数组下标，比较大小确定移动哪个下标，当达到中位数时停止即可。
 * 途中将最后两个访问的数组值存储下来，这就是结果。
 * 当然如果要考虑到数组正序和倒序的问题的话，只需要通过对比数组头尾的元素，
 * 修改下标的初始位置和移动方式即可。
 *
 */
public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int i = 0, j = 0, flag = 0, count = 0, totalLength = nums1.length + nums2.length;
        int[] result = new int[2];

        while(count < (totalLength / 2 + 1)) {
            flag ^= 1;
            count++;
            if (i == nums1.length) {
                result[flag] = nums2[j];
                ++j;
                continue;
            }
            if (j == nums2.length) {
                result[flag] = nums1[i];
                ++i;
                continue;
            }
            if (nums1[i] < nums2[j]) {
                result[flag] = nums1[i];
                ++i;
            } else {
                result[flag] = nums2[j];
                ++j;
            }
        }
        return totalLength%2 == 0 ? (result[0] + result[1]) / 2.0 : result[flag];
    }
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2}, nums2 = new int[]{3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
