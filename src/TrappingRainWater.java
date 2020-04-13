/**
 * Author: AncientAnton
 * Date: 2020/4/4
 * Description:
 */

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int prev = 0, cur = height.length - 1, max = 0;
        while (prev < height.length - 1 && height[prev + 1] >= height[prev] ) {
            ++prev;
        }
        while (cur > 0 && height[cur - 1] >= height[cur]) {
            --cur;
        }
        if (prev >= cur - 1) {
            return 0;
        }
        for(int k = 0; k < height.length; ++k) {
            if (height[k] > height[max]) {
                max = k;
            }
        }
        int result = 0, l = prev + 1, r = cur - 1;
        while (l < max) {
            if (height[l] == 0) {
                result += height[prev];
            } else if (height[l] > height[prev]) {
                prev = l;
            } else if (height[l] < height[prev]) {
                result += height[prev] - height[l];
            }
            ++l;
        }
        while (r > max) {
            if (height[r] == 0) {
                result += height[cur];
            } else if (height[r] > height[cur]) {
                cur = r;
            } else if (height[r] < height[cur]) {
                result += height[cur] - height[r];
            }
            --r;
        }
        return result;
    }

    public static void main(String[] args) {
        TrappingRainWater solution = new TrappingRainWater();
        System.out.println(solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
