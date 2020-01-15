/**
 * Author: AncientAnton
 * Date: 2018/8/4.
 * Description:
 * 根据一棵树的前序遍历与中序遍历构造二叉树。

 注意:
 你可以假设树中没有重复的元素。
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length) return null;
        return constructNode(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode constructNode(int[] preorder, int lstart, int lend, int[] inorder, int rstart, int rend) {
        if (lstart > lend || rstart > rend) return null;
        TreeNode root = new TreeNode(preorder[lstart]);
        int rootIndex = rstart;
        while(inorder[rootIndex] != root.val && rootIndex <= rend) ++rootIndex;
        int leftTreeLen = rootIndex - rstart;
        root.left = constructNode(preorder, lstart + 1, lstart + leftTreeLen, inorder, rstart, rootIndex - 1);
        root.right = constructNode(preorder, lstart + leftTreeLen + 1, lend, inorder, rootIndex + 1, rend);
        return root;
    }

    public void test(){
        TreeNode result = buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
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
        ConstructBinaryTreeFromPreorderAndInorderTraversal solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        solution.test();
    }
}
