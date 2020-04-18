import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: AncientAnton
 * Date: 2020/4/18
 * Description:
 */

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<Integer> orinary = new ArrayList<Integer>(len);
        for (int i = 0; i < len; ++i) {
            orinary.add(nums[i]);
        }
        List<List<Integer>> result = new LinkedList<>();
        backtrack(result, orinary, 0, len);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> orinary, int first, int len) {
        if (first == len) {
            result.add(new ArrayList<>(orinary));
            return;
        }
        for (int i = first; i < len; ++i) {
            Collections.swap(orinary, first, i);
            backtrack(result, orinary, first + 1, len);
            Collections.swap(orinary, first, i);
        }
    }

    private void print(List<Integer> nums) {
        System.out.print('[');
        if (!nums.isEmpty()) {
            System.out.print(nums.get(0));
            for (int i = 1; i < nums.size(); ++i) {
                System.out.print(',');
                System.out.print(nums.get(i));
            }
        }

        System.out.println(']');
    }

    private void printArray(List<List<Integer>> nums) {
        System.out.println('[');
        if (!nums.isEmpty()) {
            for (int i = 0; i < nums.size(); ++i) {
                System.out.print("    ");
                print(nums.get(i));
            }
        }
        System.out.println(']');
    }

    public static void main(String[] args) {
        Permutations solution = new Permutations();
        solution.printArray(solution.permute(new int[]{1, 3, 2}));
    }
}
