import util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

import static util.ListNode.*;

/**
 * Author: AncientAnton
 * Date: 2018/7/31.
 * Description:
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

     示例:

     输入:
     [
     1->4->5,
     1->3->4,
     2->6
     ]
     输出: 1->1->2->3->4->4->5->6
 */

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (x,y) ->(x.val - y.val));
        for (int i = 0; i < lists.length; ++i) {
            if (lists[i] != null) queue.add(lists[i]);
        }
        ListNode result = new ListNode(0), head = result;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            if (head == null) {
                head = new ListNode(node.val);
            } else {
                head.next = new ListNode(node.val);
                head = head.next;
            }
            if (node.next != null) queue.add(node.next);
        }
        return result.next;
    }

    public void test(){
        printNode(mergeKLists(new ListNode[]{
                creatNode(new int[]{3,6,6,8}),
                creatNode(new int[]{1,2,6}),
                creatNode(new int[]{6,16,62}),
                creatNode(new int[]{1,872}),
                creatNode(new int[]{2,8}),
                creatNode(new int[]{1,62,93245})
        }));
    }

    public static void main(String[] args) {
        MergeKSortedLists solution = new MergeKSortedLists();
        solution.test();
    }
}
