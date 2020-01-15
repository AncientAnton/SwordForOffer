package sort;

import java.util.Arrays;

/**
 * Author: AncientAnton
 * Date: 2018/8/8.
 * Description:
 * 冒泡排序，从左到右不断的比较交换相邻的元素，
 * 在一轮交换之后，可以将最大值浮动到右侧。
 * 也可以选择从右到左冒泡，原理是一样的。
 */
public class BubbleSort {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sort(int[] nums) {
        boolean sorted = false;
        int i, j, len = nums.length;
        for (i = 0; i < len && !sorted; ++i) {
            sorted = true;
            for (j = 0; j < len - i - 1; ++j) {
                if (nums[j] > nums[j+1]) {
                    sorted = false;
                    swap(nums, j, j+1);
                }
            }
        }
    }

    public void test(){
        int[] nums = new int[]{2,6,4,5,5,1,4262,2,563};
        sort(nums);
        Arrays.stream(nums).forEach(x -> System.out.print(x + " "));
    }

    public static void main(String[] args) {
        BubbleSort solution = new BubbleSort();
        solution.test();
    }
}
