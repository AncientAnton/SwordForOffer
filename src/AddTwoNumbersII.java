import java.util.ArrayList;
import java.util.List;

/**
 * Author: AncientAnton
 * Date: 2020/4/18
 * Description:
 */

public class AddTwoNumbersII {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode t1 = l1, t2 = l2;
        List<ListNode> a1 = new ArrayList<>();
        while (t1 != null) {
            a1.add(t1);
            t1 = t1.next;
        }

        List<ListNode> a2 = new ArrayList<>();
        while (t2 != null) {
            a2.add(t2);
            t2 = t2.next;
        }
        int fix = a1.size() - a2.size();
        if (fix < 0) {
            List<ListNode> temp = a1;
            a1 = a2;
            a2 = temp;
        } else {
            fix = -fix;
        }
        int carry = 0;
        for (int i = a1.size() - 1; i >= 0; --i) {
            ListNode cur = a1.get(i);
            if (i + fix >= 0) {
                cur.val = cur.val + a2.get(i + fix).val;
            }
            cur.val = cur.val + carry;
            carry = cur.val / 10;
            cur.val %= 10;
        }
        if (carry == 0) {
            return a1.get(0);
        } else {
            ListNode result = new ListNode(carry);
            result.next = a1.get(0);
            return result;
        }
    }
}
