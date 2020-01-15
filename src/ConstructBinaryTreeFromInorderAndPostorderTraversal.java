/**
 * Author: AncientAnton
 * Date: 2018/8/4.
 * Description:
 * 根据一棵树的前序遍历与中序遍历构造二叉树。

 注意:
 你可以假设树中没有重复的元素。
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        if (inOrder == null || postOrder == null || inOrder.length == 0 || postOrder.length == 0 || inOrder.length != postOrder.length) return null;
        return constructNode(inOrder, 0, inOrder.length - 1, postOrder, 0, postOrder.length - 1);
    }

    private TreeNode constructNode(int[] inOrder, int lstart, int lend, int[] postOrder, int rstart, int rend) {
        if (lstart > lend || rstart > rend) return null;
        TreeNode root = new TreeNode(postOrder[rend]);
        int rootIndex = lstart;
        while(inOrder[rootIndex] != root.val && rootIndex <= lend) ++rootIndex;
        int leftTreeLen = rootIndex - lstart;
        root.left = constructNode(inOrder, lstart, rootIndex -1, postOrder, rstart, rstart + leftTreeLen - 1);
        root.right = constructNode(inOrder, rootIndex + 1, lend, postOrder, rstart + leftTreeLen, rend - 1);
        return root;
    }

    public void test(){
        TreeNode result = buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
        printWithPreOrder(result);
        System.out.println();
        printWithInOrder(result);
        System.out.println();
        printWithPostOrder(result);
        System.out.println();
    }

    public void printWithPreOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printWithPreOrder(root.left);
        printWithPreOrder(root.right);
    }

    public void printWithInOrder(TreeNode root) {
        if (root == null) return;
        printWithInOrder(root.left);
        System.out.print(root.val + " ");
        printWithInOrder(root.right);
    }

    public void printWithPostOrder(TreeNode root) {
        if (root == null) return;
        printWithPostOrder(root.left);
        printWithPostOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderAndPostorderTraversal solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
        solution.test();
    }
}
