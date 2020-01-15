package sort;

import java.util.Arrays;

/**
 * Author: AncientAnton
 * Date: 2018/8/8.
 * Description:
 * 快速排序通过一个切分元素将数组分为两个子数组，
 * 左子数组小于等于切分元素，右子数组大于等于切分元素，
 * 将这两个子数组排序也就将整个数组排序了.
 */
public class QuickSort {

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int l = left, r = right + 1, sign = nums[left];
        while (true) {
            while (nums[++l] > sign && l != right);
            while (nums[--r] < sign && r != left);
            if (l >= r) break;
            swap(nums, l, r);
        }
        swap(nums, left, r);
        quickSort(nums, left, r - 1);
        quickSort(nums, r + 1, right);
    }

    public void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public void test(){
        int[] nums = new int[]{2,6,4,5,5,1,4262,2,563};
        sort(nums);
        Arrays.stream(nums).forEach(x -> System.out.print(x + " "));
    }

    public static void main(String[] args) {
        QuickSort solution = new QuickSort();
        solution.test();
    }
}
