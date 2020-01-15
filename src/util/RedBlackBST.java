package util;

/**
 * Author: AncientAnton
 * Date: 2018/8/2.
 * Description:
 * 红黑树：
 （1）每个节点或者是黑色，或者是红色。
 （2）根节点是黑色。
 （3）每个叶子节点（NIL）是黑色。 [注意：这里叶子节点，是指为空(NIL或NULL)的叶子节点！]
 （4）如果一个节点是红色的，则它的子节点必须是黑色的。
 （5）从一个节点到该节点的子孙节点的所有路径上包含相同数目的黑节点。
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> extends BST<Key, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private boolean isRed(Node x) {
        if (x == null)
            return false;
        return x.color == RED;
    }

    // 对x进行左旋，意味着"将x变成一个左节点"。
    // 如果出现右链接为红链接（红色连接红色），那么就需要进行左旋转操作
    protected Node rotateLeft(Node x) {
        Node r = x.right;
        x.right = r.left;
        r.left = x;

        // 相当于R替代了X的位置，X的左子树不变，但是X的右子树变成了R的左子树
        // 设置颜色和子节点数目
        r.color = x.color;
        x.color = RED;
        r.amount = x.amount;

        recalculateSize(x);
        return x;
    }

    // 对x进行右旋，意味着"将x变成一个右节点"。
    // 如果出现两个连续的左连接位红连接（红色连接红色），那么就需要进行右旋操作
    protected Node rotateRight(Node x) {
        Node l = x.left;
        x.left = l.right;
        l.right = x;
        // 相当于L替代了X的位置，L的左子树不变，但是右子树变成了X的左子树
        // 设置颜色和子节点数目
        l.color = x.color;
        x.color = RED;
        l.amount = x.amount;

        recalculateSize(x);
        return x;
    }

    // 颜色转换
    protected void filpColor(Node x) {
        x.color = RED;
        x.left.color = BLACK;
        x.right.color = BLACK;
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    @Override
    protected Node put(Node x, Key key, Value value) {
        if (x == null) {
            Node node = new Node(key, value, 1);
            node.color = RED;
            return node;
        }

        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            x.val = value;
        } else if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else {
            x.right = put(x.right, key, value);
        }

        // 开始进行变换，保持红黑树的性质
        if (isRed(x.right) && !isRed(x.left)) {
            rotateLeft(x);
        } else if (isRed(x.left) && isRed(x.left.left)) {
            rotateRight(x);
        } else if (isRed(x.left) && isRed(x.right)) {
            filpColor(x);
        }

        recalculateSize(x);
        return x;
    }
}
