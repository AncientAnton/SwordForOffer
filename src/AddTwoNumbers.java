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
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void printListNode(ListNode node) {
        ListNode tmp = node;
        if (tmp == null) {
            System.out.println(tmp);
        }
        System.out.print(tmp.val);
        while (tmp.next != null) {
            System.out.print("->" + tmp.next.val);
            tmp = tmp.next;
        }
        System.out.println();
    }

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

    public static void main(String[] args) {
        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode l1 = new AddTwoNumbers.ListNode(8);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(2);

        solution.printListNode(solution.addTwoNumbers(l1, l2));

    }
}
