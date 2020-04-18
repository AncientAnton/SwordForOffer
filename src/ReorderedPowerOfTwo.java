import java.util.Arrays;

/**
 * Author: AncientAnton
 * Date: 2020/4/18
 * Description:
 */

public class ReorderedPowerOfTwo {

    private static int[][] powerNums = new int[31][10];
    static {
        for (int i = 0; i < 31; ++i) {
            int N = 1 << i;
            while (N > 0) {
                powerNums[i][N % 10]++;
                N /= 10;
            }
        }
    }

    public boolean reorderedPowerOf2(int N) {
        int[] nums = get(N);
        for (int i = 0; i < 31; ++i) {
            if (Arrays.equals(nums, powerNums[i])) {
                return true;
            }
        }
        return false;
    }

    public int[] get(int N) {
        int[] ans = new int[10];
        while (N > 0) {
            ans[N % 10]++;
            N /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        ReorderedPowerOfTwo solution = new ReorderedPowerOfTwo();
        System.out.println(3 + " = " + solution.reorderedPowerOf2(3));
        System.out.println(65563 + " = " + solution.reorderedPowerOf2(65563));

    }

}
