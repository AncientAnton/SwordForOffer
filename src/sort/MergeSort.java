package sort;

import java.util.Arrays;

/**
 * Author: AncientAnton
 * Date: 2018/8/8.
 * Description:
 * 将数组分成两部分，分别进行排序，然后归并起来。
 * 可以自上到下，不断拆分。
 * 也可以自下到上，不断合并。
 */
public class MergeSort {
    int[] helper;

    public void merge(int[] nums, int left, int middle, int right) {
        for (int x = left; x <= right; ++x) helper[x] = nums[x];
        helper = Arrays.copyOf(nums, nums.length);
        int i = left, tl = left, tr = middle + 1;
        while (i <= right) {
            if (tl > middle) nums[i++] = helper[tr++];
            else if (tr > right) nums[i++] = helper[tl++];
            else if (nums[tl] < nums[tr]) {
                nums[i++] = helper[tl++];
            } else {
                nums[i++] = helper[tr++];
            }
        }
    }

    public void mergeSortDownToUp(int[] nums) {
        int l, len = nums.length, mSize;
        for (mSize = 1; mSize < len; mSize += mSize) {
            for (l = 0; l < len - mSize; l += mSize + mSize) {
                merge(nums, l, l + mSize - 1, Math.min(l + mSize + mSize - 1, len - 1));
            }
        }
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int middle = left + (right - left) / 2;
        mergeSort(nums, left, middle);
        mergeSort(nums, middle + 1, right);
        merge(nums, left, middle, right);
    }

    public void sort(int[] nums) {
        helper = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
    }

    public void test(){
        int[] nums = new int[]{2,6,4,5,5,1,4262,2,563};
        sort(nums);
        Arrays.stream(nums).forEach(x -> System.out.print(x + " "));
    }

    public static void main(String[] args) {
        MergeSort solution = new MergeSort();
        solution.test();
    }
}
