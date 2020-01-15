import java.util.LinkedList;
import java.util.List;

/**
 * Author: AncientAnton
 * Date: 2018/7/31.
 * Description:
     给出 n 代表生成括号的对数，请你写出一个函数，
     使其能够生成所有可能的并且有效的括号组合。

     例如，给出 n = 3，生成结果为：

     [
     "((()))",
     "(()())",
     "(())()",
     "()(())",
     "()()()"
     ]
 *
 */
public class GgenerateParentheses {
    class Status {
        StringBuilder builder;
        int leftNeedMatch;
        int leftMatched;

        Status() {
            builder = new StringBuilder();
        }

        Status(Status status) {
            leftNeedMatch = status.leftNeedMatch;
            leftMatched = status.leftMatched;
            builder = new StringBuilder(status.builder);
        }

        Status append(char c) {
            if (c == '(') {
                ++leftNeedMatch;
            } else if (c == ')') {
                --leftNeedMatch;
                ++leftMatched;
            }
            builder.append(c);
            return this;
        }

        boolean valid(int n, char c) {
            if (c == '(') {
                return leftNeedMatch + leftMatched < n;
            } else if (c == ')') {
                return leftNeedMatch > 0;
            }
            return false;
        }

        boolean complete(int n) {
            return leftMatched == n && leftNeedMatch == 0;
        }

        String val() {
            return builder.toString();
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        char left = '(', right = ')';
        if (n == 0) return result;

        LinkedList<Status> toDo = new LinkedList<>();
        Status start = new Status();
        start.append(left);
        toDo.push(start);

        while (!toDo.isEmpty()) {
            Status status = toDo.peek();
            if (status.complete(n)) {
                result.add(status.val());
                toDo.pop();
                continue;
            }

            boolean canPushLeft = status.valid(n, left);
            boolean canPushRight = status.valid(n, right);

            if (canPushLeft) {
                if (canPushRight) {
                    Status newStatus = new Status(status);
                    newStatus.append(right);
                    toDo.push(newStatus);
                    status.append(left);
                } else {
                    status.append(left);
                }
            } else if (canPushRight) {
                status.append(right);
            }
        }
        return result;
    }

    public void test(){
        System.out.println(generateParenthesis(2));
    }
    public static void main(String[] args) {
        GgenerateParentheses solution = new GgenerateParentheses();
        solution.test();
    }
}
