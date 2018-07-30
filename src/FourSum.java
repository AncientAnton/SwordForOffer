import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Author: AncientAnton
 * Date: 2018/7/31.
 * Description:
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，
 * 判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？
 * 找出所有满足条件且不重复的四元组。
 * 注意： 答案中不可以包含重复的四元组。
 *
    给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

    满足要求的四元组集合为：
    [
    [-1,  0, 0, 1],
    [-2, -1, 1, 2],
    [-2,  0, 0, 2]
    ]
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList result = new ArrayList();
        if (nums == null || nums.length < 3) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; ++i) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            List<List<Integer>> threeSumResult = threeSum(nums,i + 1,target - nums[i]);
            for (int j = 0; j < threeSumResult.size(); ++j) {
                ArrayList<Integer> tmp = new ArrayList(4);
                tmp.add(nums[i]);
                tmp.addAll(threeSumResult.get(j));
                result.add(tmp);
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum(int[] nums, int start, int target) {
        ArrayList result = new ArrayList();
        if (nums == null || nums.length < 3) return result;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = start; i < n - 2; ++i) {
            if (i > start && nums[i - 1] == nums[i]) continue;
            int j = i + 1, k = n - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == target) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < n - 1 && nums[j] == nums[j+1]) ++j;
                    while (k > start && nums[k] == nums[k-1]) --k;
                    ++j;
                    --k;
                } else if (nums[i] + nums[j] + nums[k] > target) {
                    while (k > start && nums[k] == nums[k-1]) --k;
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
        FourSum solution = new FourSum();
        System.out.println(solution.fourSum(new int[]{1, 0, -1, 0, -2, 2, 0}, 0));
    }
}
