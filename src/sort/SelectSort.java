package sort;

import java.util.Arrays;

/**
 * Author: AncientAnton
 * Date: 2018/8/8.
 * Description:
 * 选择排序，选择数组中最小的元素，与数组头交换，不断重复
 */
public class SelectSort {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sort(int[] nums) {
        int i, j, min, len = nums.length;
        for (i = 0; i < len - 1; ++i) {
            min = i;
            for (j = i + 1; j < len; ++j) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }

    public void test(){
        int[] nums = new int[]{2,6,4,5,5,1,4262,2,563};
        sort(nums);
        Arrays.stream(nums).forEach(x -> System.out.print(x + " "));
    }
    public static void main(String[] args) {
        SelectSort solution = new SelectSort();
        solution.test();
    }
}
