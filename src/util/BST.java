package util;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: AncientAnton
 * Date: 2018/8/2.
 * Description:
 *
 * 二叉查找树
 * 一颗二叉树
 * 每个节点的值大于等于其左子树中的所有节点的值
 * 每个节点的值小于等于右子树的所有节点的值。
 */
public class BST<Key extends Comparable<Key>, Value> implements OrderedSt<Key, Value> {

    protected Node root;

    protected class Node {
        Key key;
        Value val;
        Node left;
        Node right;
        int amount;
        boolean color;

        public Node(Key key, Value val, int amount) {
            this.key = key;
            this.val = val;
            this.amount = amount;
        }
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.amount;
    }

    protected void recalculateSize(Node x) {
        x.amount = 1 + size(x.left) + size(x.right);
    }

    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    protected Value get(Node x, Key key) {
        if (x == null || key == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x.val;
        else if (cmp < 0) return get(x.left, key);
        else return get(x.right, key);
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    protected Node put(Node x, Key key, Value value) {
        if (x == null) return new Node(key, value, 1);
        int cmp = key.compareTo(x.key);
        if (cmp == 0) x.val = value;
        else if (cmp < 0) x.left = put(x.left, key, value);
        else x.right = put(x.right, key, value);
        recalculateSize(x);
        return x;
    }

    @Override
    public Key min() {
        Node minNode = min(root);
        return minNode != null ? minNode.key : null;
    }

    protected Node min(Node x) {
        if (x == null) return null;
        if (x.left == null) return x;
        return min(x.left);
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    // 令指向最小节点的链接指向最小节点的右子树。
    public Node deleteMin(Node x) {
        if (x.left == null)
            return x.right;
        x.left = deleteMin(x.left);
        recalculateSize(x);
        return x;
    }

    // 如果待删除的节点只有一个子树
    // 那么只需要让指向待删除节点的链接指向唯一的子树即可；
    //否则，让右子树的最小节点替换该节点。
    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = delete(x.left, key);
        else if (cmp > 0)
            x.right = delete(x.right, key);
        else {
            if (x.right == null)
                return x.left;
            if (x.left == null)
                return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        recalculateSize(x);
        return x;
    }

    @Override
    public Key max() {
        Node maxNode = max(root);
        return maxNode != null ? maxNode.key : null;
    }

    protected Node max(Node x) {
        if (x == null) return null;
        if (x.right == null) return x;
        return max(x.right);
    }

    // 小于或等于Key的最大值
    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null)
            return null;
        return x.key;
    }

    protected Node floor(Node x, Key key) {
        if (x == null || key == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0)
            return x;
        if (cmp < 0)
            return floor(x.left, key);
        Node t = floor(x.right, key);
        return t != null ? t : x;
    }

    // 返回key的排名
    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        if (x == null)
            return 0;
        int cmp = key.compareTo(x.key);
        if (cmp == 0)
            return size(x.left);
        else if (cmp < 0)
            return rank(key, x.left);
        else
            return 1 + size(x.left) + rank(key, x.right);
    }

    @Override
    public List<Key> keys(Key l, Key h) {
        return keys(root, l, h);
    }

    // 利用二叉查找树中序遍历的结果为递增的特点
    private List<Key> keys(Node x, Key l, Key h) {
        List<Key> list = new ArrayList<>();
        if (x == null) return list;
        int cmpl = l.compareTo(x.key);
        int cmpr = l.compareTo(x.key);
        if (cmpl < 0) {
            list.addAll(keys(x.left, l, h));
        }
        if (cmpl <= 0 && cmpr >= 0) {
            list.add(x.key);
        }
        if (cmpr > 0) {
            list.addAll(keys(x.right, l, h));
        }
        return list;
    }
}
