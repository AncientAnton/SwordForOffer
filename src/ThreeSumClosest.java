import java.util.Arrays;

/**
 * Author: AncientAnton
 * Date: 2018/7/31.
 * Description:
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。

 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return target;
        Arrays.sort(nums);
        int n = nums.length, result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < n - 2; ++i) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int j = i + 1, k = n - 1;
            while (j < k) {
                if (Math.abs(nums[i] + nums[j] + nums[k] - target) < Math.abs(result - target)) {
                    result = nums[i] + nums[j] + nums[k];
                }
                if (nums[i] + nums[j] + nums[k] == target) {
                    return target;
                } else if (nums[i] + nums[j] + nums[k] > target) {
                    while (k > 0 && nums[k] == nums[k-1]) --k;
                    --k;
                } else {
                    while (j < n - 1 && nums[j] == nums[j+1]) ++j;
                    ++j;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        ThreeSumClosest solution = new ThreeSumClosest();
        System.out.println(solution.threeSumClosest(new int[]{0,0,0,0,0,0,0,0,4}, 1));
    }
}
