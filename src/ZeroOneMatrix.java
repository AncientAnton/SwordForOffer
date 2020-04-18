import java.util.LinkedList;

/**
 * Author: AncientAnton
 * Date: 2020/4/18
 * Description:
 */

public class ZeroOneMatrix {
    private int width;
    private int height;
    private int[][] mat;
    private int[][] dis;

    private LinkedList<Integer> queue = new LinkedList<>();

    private int distance(int i, int j) {return dis[i][j];}
    private void setDis(int i, int j, int d) {dis[i][j] = d;}
    private boolean zero(int i, int j) {return mat[i][j] == 0;}
    private boolean one(int i, int j) {return mat[i][j] == 1;}
    private void enque(int i, int j) {queue.add(i * width + j);}
    private void deal(int i, int j, int cd) {
        if (i < 0 || i >= height || j < 0 || j >= width) {
            return;
        }
        if (one(i, j)) {
            if (distance(i, j) == 0 || cd < distance(i, j)) {
                setDis(i, j, cd);
                enque(i, j);
            }
        }
    }
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }
        queue.clear();
        width = matrix[0].length;
        height = matrix.length;
        mat = matrix;
        dis = new int[height][width];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if(zero(i, j)){
                    enque(i, j);
                }
            }
        }
        while (!queue.isEmpty()) {
            int item = queue.removeFirst();
            int i = item / width;
            int j = item % width;
            int cd = 1 + distance(i, j);
            deal(i - 1, j, cd);
            deal(i + 1, j, cd);
            deal(i, j - 1, cd);
            deal(i, j + 1, cd);

        }
        return dis;
    }
}
