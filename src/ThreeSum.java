import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: AncientAnton
 * Date: 2018/7/31.
 * Description:
 *
    给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
    找出所有满足条件且不重复的三元组。

    注意：答案中不可以包含重复的三元组。

    例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

    满足要求的三元组集合为：
    [
    [-1, 0, 1],
    [-1, -1, 2]
    ]
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList result = new ArrayList();
        if (nums == null || nums.length < 3) return result;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; ++i) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int j = i + 1, k = n - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < n - 1 && nums[j] == nums[j+1]) ++j;
                    while (k > 0 && nums[k] == nums[k-1]) --k;
                    ++j;
                    --k;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
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
        ThreeSum solution = new ThreeSum();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
