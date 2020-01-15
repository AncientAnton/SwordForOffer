/**
 * Author: AncientAnton
 * Date: 2018/7/31.
 * Description:
 *
 *  给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。

 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

 示例 1:

 给定 nums = [3,2,2,3], val = 3,

 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。

 你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i, swap = -1;
        for (i = nums.length - 1; i >= 0; --i) {
            if (nums[i] != val) {
                swap = i;
                break;
            }
        }
        if (swap == -1) return 0;
        for (i = swap; i >= 0; --i) {
            if (nums[i] == val) {
                nums[i] = nums[swap];
                swap = swap - 1;
            }
        }
        return swap + 1;
    }

    public void test(){
        System.out.println(removeElement(new int[]{2}, 3));
        System.out.println(removeElement(new int[]{0,4,4,0,4,4,4,0,2}, 4));
    }
    public static void main(String[] args) {
        RemoveElement solution = new RemoveElement();
        solution.test();
    }
}
