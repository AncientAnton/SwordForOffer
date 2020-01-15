import util.ListNode;
import static util.ListNode.*;
/**
 * Author: AncientAnton
 * Date: 2018/7/29.
 * Description:
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = l1;
        int carry = 0;
        while (l2 != null) {
            l1.val = l1.val + l2.val + carry;
            carry = l1.val / 10;
            l1.val = l1.val % 10;
            if (l1.next == null) {
                if (l2.next != null || carry > 0) {
                    l1.next = new ListNode(carry);
                    l1 = l1.next;
                    carry = 0;
                }
            } else {
                l1 = l1.next;
                l1.val += carry;
                carry = 0;
            }
            l2 = l2.next;
        }

        while (l1 != null && l1.val >= 10) {
            carry = l1.val / 10;
            l1.val = l1.val % 10;
            if (l1.next == null) {
                l1.next = new ListNode(carry);
                break;
            } else {
                l1 = l1.next;
                l1.val += carry;
            }
        }
        return result;
    }

    public void test() {

    }

    public static void main(String[] args) {
        AddTwoNumbers solution = new AddTwoNumbers();
        solution.test();
    }
}
