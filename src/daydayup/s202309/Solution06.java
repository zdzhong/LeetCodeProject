package daydayup.s202309;

import javafx.util.Pair;

public class Solution06 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(4);
        TreeNode root4 = new TreeNode(5);
        TreeNode root5 = new TreeNode(6);
        TreeNode root6 = new TreeNode(7);
        root.left = root1;
        root.right = root2;
        root1.left = root3;
        root1.right = root4;
        root2.left = root5;
        root2.right = root6;
        TreeNode node = lcaDeepestLeaves(root);
        f(node);
    }

    public static TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).getKey();
    }

    public static void f(TreeNode root) {
        if (null == root) {
            return;
        }
        System.out.print(root.val);
        f(root.left);
        f(root.right);
    }

    public static Pair<TreeNode, Integer> dfs(TreeNode root) {
        if (null == root) {
            return new Pair<>(root, 0);
        }
        Pair<TreeNode, Integer> left = dfs(root.left);
        Pair<TreeNode, Integer> right = dfs(root.right);
        if (left.getValue() > right.getValue()) {
            return new Pair<>(left.getKey(), left.getValue() + 1);
        }
        if (left.getValue() < right.getValue()) {
            return new Pair<>(right.getKey(), right.getValue() + 1);
        }
        return new Pair<>(root, left.getValue() + 1);
    }
}
