import java.util.Arrays;

/**
 * Author: AncientAnton
 * Date: 2018/8/1.
 * Description:
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) return;
        if (nums.length == 2) {
            swap(nums, 0, 1);
            return;
        }
        int len = nums.length;
        for(int i = len - 1; i > 0; i--) {
            if(nums[i] > nums[i - 1]) {
                for(int j = len - 1; j >= i; j--)
                    if(nums[j] > nums[i - 1]) {
                        swap(nums, i - 1, j);
                        break;
                    }
                for(int j = 0; j < (len - i) / 2; j++)
                    swap(nums, i + j, len - j - 1);
                return;
            }
        }
        for(int j = 0; j < len/ 2; j++)
            swap(nums, j, len - j - 1);
    }

    public void swap(int nums[], int start, int end) {
        if (start < 0 || end < 0 || start >= nums.length || end >= nums.length || start == end) return;
        int tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
    }

    public void pringList(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            System.out.print(nums[i]);
        }
        System.out.println();
    }
    public void test(){
        int[] nums = new int[]{1,2,3,4,5,6,7};
        nextPermutation(nums);
        pringList(nums);
        nextPermutation(nums);
        pringList(nums);        nextPermutation(nums);
        pringList(nums);        nextPermutation(nums);
        pringList(nums);        nextPermutation(nums);
        pringList(nums);        nextPermutation(nums);
        pringList(nums);        nextPermutation(nums);
        pringList(nums);        nextPermutation(nums);
        pringList(nums);        nextPermutation(nums);
        pringList(nums);        nextPermutation(nums);
        pringList(nums);        nextPermutation(nums);
        pringList(nums);        nextPermutation(nums);
        pringList(nums);        nextPermutation(nums);
        pringList(nums);        nextPermutation(nums);
        pringList(nums);        nextPermutation(nums);
        pringList(nums);        nextPermutation(nums);
        pringList(nums);
    }
    public static void main(String[] args) {
        NextPermutation solution = new NextPermutation();
        solution.test();
    }
}
