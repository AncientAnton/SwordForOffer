import java.util.HashMap;

/**
 * Author: AncientAnton
 * Date: 2018/7/29.
 * Description:
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 每个输入只对应一种答案，且同样的元素不能被重复利用
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 2) {
            return new int[]{0, 1};
        }
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (indexMap.containsKey(target - nums[i])) {
                return new int[]{indexMap.get(target - nums[i]),i};
            }
            indexMap.put(nums[i], i);
        }
        return new int[]{0, 1};
    }

    public static void main(String[] args) {
        int target = 6;
        int[] nums = new int[]{3,3};
        int[] result = twoSum(nums, target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
