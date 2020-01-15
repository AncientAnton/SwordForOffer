package sort;

import java.util.Arrays;

/**
 * Author: AncientAnton
 * Date: 2018/8/8.
 * Description:
 * 希尔排序使用插入排序对间隔 h 的序列进行排序。
 * 通过不断减小 h，最后令 h=1，就可以使得整个数组是有序的。
 */
public class ShellSort {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sort(int[] nums) {
        int i, j, len = nums.length, h = 1;
        while (h < len / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (i = h; i < len; ++i) {
                for (j = i; j >= h && nums[j] < nums[j - h]; j = j - h) {
                    swap(nums, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public void test(){
        int[] nums = new int[]{2,6,4,5,5,1,4262,2,563};
        sort(nums);
        Arrays.stream(nums).forEach(x -> System.out.print(x + " "));
    }

    public static void main(String[] args) {
        ShellSort solution = new ShellSort();
        solution.test();
    }
}
