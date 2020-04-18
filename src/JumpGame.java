/**
 * Author: AncientAnton
 * Date: 2020/4/18
 * Description:
 */

public class JumpGame {
    public boolean canJump(int[] nums) {
        int rightmost = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > rightmost) {
                return false;
            }
            rightmost = Math.max(rightmost, i + nums[i]);
        }
        return true;
    }
}
