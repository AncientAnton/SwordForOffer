import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: AncientAnton
 * Date: 2018/7/31.
 * Description:
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

    给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
    2-abc,3-def,4-ghi,5-jkl,6-mno,7-pqrs,8-tuv,9-wxyz
    示例:

    输入："23"
    输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return new ArrayList<>();
        char[][] charMap = new char[][]{{'a','b','c'},{'d','e','f'},
                {'g','h','i'},{'j','k','l'},
                {'m','n','o'},{'p','q','r','s'},
                {'t','u','v'},{'w','x','y','z'}};
        int count = 1;
        for (int i = 0; i < digits.length(); ++i) {
            if (digits.charAt(i) == '7' || digits.charAt(i) == '9') {
                count *= 4;
            } else {
                count *= 3;
            }
        }
        List<String> result = new ArrayList<>(count);
        char c;
        for (int i = 0; i < count; ++i) {
            int tmp = i;
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < digits.length(); ++j) {
                c = digits.charAt(j);
                int modLen = (c == '7' || c == '9') ? 4 : 3;
                builder.append(charMap[c - '2'][tmp%modLen]);
                tmp /= modLen;
            }
            result.add(builder.toString());
        }
        return result;
    }
    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber solution = new LetterCombinationsOfAPhoneNumber();
        solution.letterCombinations("45");
    }
}
