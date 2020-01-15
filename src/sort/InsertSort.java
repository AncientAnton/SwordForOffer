package sort;

import java.util.Arrays;

/**
 * Author: AncientAnton
 * Date: 2018/8/8.
 * Description:
 * 不断的将值插入到左边的有序数组中
 */
public class InsertSort {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sort(int[] nums) {
        int i, j, len = nums.length;
        for (i = 1; i < len; ++i) {
            for (j = i; j > 0 && nums[j] < nums[j - 1]; --j) {
                swap(nums, j - 1, j);
            }
        }
    }

    public void test(){
        int[] nums = new int[]{2,6,4,5,5,1,4262,2,563};
        sort(nums);
        Arrays.stream(nums).forEach(x -> System.out.print(x + " "));
    }

    public static void main(String[] args) {
        InsertSort solution = new InsertSort();
        solution.test();
    }
}
