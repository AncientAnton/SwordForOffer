import java.util.*;

/**
 * Author: AncientAnton
 * Date: 2018/8/1.
 * Description:
 *
 * 给定一个字符串 s 和一些长度相同的单词 words。
 * 在 s 中找出可以恰好串联 words 中所有单词的子串的起始位置。
 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。

 输入:
 s = "barfoothefoobarman",
 words = ["foo","bar"]
 输出: [0,9]
 解释: 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
 输出的顺序不重要, [9,0] 也是有效答案。
 */
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || words.length == 0 || words[0] == null || words[0].length() == 0) return new ArrayList<>();
        int wcount = words.length, len = words[0].length(), tlen = wcount * words[0].length();
        if (s.length() < wcount * words[0].length()) return new ArrayList<>();

        Map<String, Boolean> wordMap = new HashMap<>();
        Map<String, Integer> matchCount = new HashMap<>();
        for (int i = 0; i < wcount; ++i) {
            wordMap.put(words[i], true);
            if (matchCount.containsKey(words[i])) {
                matchCount.put(words[i], matchCount.get(words[i]) + 1);
            } else {
                matchCount.put(words[i], 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        int i, j;
        for (i = 0; i <= s.length() - tlen; ++i) {
            for (j = i; j < i + tlen; j += len) {
                String key = s.substring(j, j + len);
                if (!wordMap.containsKey(key)) {
                    break;
                } else {
                    int val = matchCount.get(key);
                    if (val > 0) {
                        matchCount.put(key, val - 1);
                    } else {
                        break;
                    }
                }
            }
            if (j == i + tlen) {
                result.add(i);
            }
            matchCount.clear();
            for (int x = 0; x < wcount; ++x) {
                if (matchCount.containsKey(words[x])) {
                    matchCount.put(words[x], matchCount.get(words[x]) + 1);
                } else {
                    matchCount.put(words[x], 1);
                }
            }
        }
        return result;
    }

    // TODO :O(n)解法 思路是将步长设为单词长度，使用哈希表记录状态变化
    public List<Integer> findSubString2(String s, String[] words) {
        if (s == null || words == null || words.length == 0 || words[0] == null || words[0].length() == 0) return new ArrayList<>();
        int wcount = words.length, len = words[0].length(), tlen = wcount * words[0].length();
        if (s.length() < wcount * words[0].length()) return new ArrayList<>();

        Map<String, Boolean> wordMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        return result;
    }

    public void test() {
        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"}));
    }

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords solution = new SubstringWithConcatenationOfAllWords();
        solution.test();
    }
}
