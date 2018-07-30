/**
 * Author: AncientAnton
 * Date: 2018/7/30.
 * Description:
 *
 * 将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：
     P   A   H   N
     A P L S I I G
     Y   I   R
     之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"

     实现一个将字符串进行指定行数变换的函数:

     string convert(string s, int numRows);
     示例 1:

     输入: s = "PAYPALISHIRING", numRows = 3
     输出: "PAHNAPLSIIGYIR"
     示例 2:

     输入: s = "PAYPALISHIRING", numRows = 4
     输出: "PINALSIGYAHRPI"
     解释:

     P     I    N
     A   L S  I G
     Y A   H R
     P     I
 */
public class ZigZagConvension {
    public int indexFor(int i, int numRows) {
        if (numRows < 2) return i;

        return i;
    }
    public String convert(String s, int numRows) {
        if (s == null || s.length() < 2 || numRows < 2) return s;
        int strLen = s.length();
        int zagLength = 2 * numRows - 2;
        StringBuilder builder = new StringBuilder();
        for (int row = 0; row < numRows; ++row) {
            for (int j = 0; j + row < strLen ; j += zagLength) {
                builder.append(s.charAt(row + j));
                if (row != 0 && row != numRows - 1 && j + zagLength - row < strLen) {
                    builder.append(s.charAt(j + zagLength - row));
                }
            }
        }
        return builder.toString();
    }
    public String _convert(String s, int numRows) {
        if (s == null || s.length() < 2 || numRows < 2) return s;
        int zagLength = 2*numRows - 2;
        StringBuilder result = new StringBuilder();
        StringBuilder[] buffers = new StringBuilder[numRows];
        for (int i = 0; i < s.length(); ++i) {
            int inZagIndex = i % zagLength;
            int rowIndex = inZagIndex > numRows - 1 ? numRows - 1 - inZagIndex % numRows - 1: inZagIndex;
            if (buffers[rowIndex] == null) buffers[rowIndex] = new StringBuilder();
            buffers[rowIndex].append(s.charAt(i));
        }
        for (int i = 0; i < numRows; ++i) {
            if (buffers[i] != null) result.append(buffers[i]);
        }
        return result.toString();
    }
    public static void main(String[] args) {
        ZigZagConvension solution = new ZigZagConvension();
        System.out.println(solution.convert("PAYPALISHIRING", 3));
        System.out.println(solution.convert("PAYPALISHIRING", 4));
        System.out.println(solution.convert("PABCDE", 3));
        System.out.println(solution.convert("PABCDE", 4));
    }
}
