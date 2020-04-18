import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: AncientAnton
 * Date: 2020/4/18
 * Description:
 */

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] < o2[0]) return -1;
            if (o1[0] > o2[0]) return 1;
            if (o1[1] < o2[1]) return -1;
            if (o1[1] > o2[1]) return 1;
            return 0;
        });
        List<int[]> result = new ArrayList<>();
        int left = intervals[0][0], right = intervals[0][1];
        for (int i = 0; i < intervals.length; ++i) {
            if (intervals[i][0] <= right) {
                right = Math.max(right, intervals[i][1]);
            } else {
                result.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        result.add(new int[]{left, right});
        return result.toArray(new int[][]{});

    }
}
