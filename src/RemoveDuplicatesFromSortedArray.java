/**
 * Author: AncientAnton
 * Date: 2018/7/31.
 * Description:
 *
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

     不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     给定 nums = [0,0,1,1,1,2,2,3,3,4],

     函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

     你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length < 2) return nums.length;
        int count = 0, ptr = 1;
        while (ptr < nums.length) {
            if (nums[ptr] != nums[count]) {
                count = count + 1;
                nums[count] = nums[ptr];
            }
            ptr = ptr + 1;
        }
        return count + 1;
    }

    public void test(){
        System.out.println(removeDuplicates(new int[]{1,1,2}));
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();
        solution.test();
    }
}
