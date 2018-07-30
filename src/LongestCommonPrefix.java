/**
 * Author: AncientAnton
 * Date: 2018/7/30.
 * Description:
 *
 *  编写一个函数来查找字符串数组中的最长公共前缀。

    如果不存在公共前缀，返回空字符串 ""。

    示例 1:

    输入: ["flower","flow","flight"]
    输出: "fl"
    示例 2:

    输入: ["dog","racecar","car"]
    输出: ""
    解释: 输入不存在公共前缀。
    说明:

    所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        for (int i = 0; i < strs.length; ++i) {
            if (strs[i] == null || strs[i].isEmpty()) {
                return "";
            }
        }
        int index = 0, match = -1;
        for (;index < strs.length; ++index) {
            if (match + 1 == strs[index].length() || match +1 == strs[0].length()) {
                break;
            }
            if (index != 0 && strs[index].charAt(match + 1) != strs[0].charAt(match + 1)) {
                break;
            }
            if (index == strs.length - 1) {
                match += 1;
                index = 0;
            }
        }
        if (match != -1) {
            return strs[0].substring(0, match + 1);
        }
        return "";
    }
    public static void main(String[] args) {
        LongestCommonPrefix solution = new LongestCommonPrefix();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"aa","aa"}));
    }
}
