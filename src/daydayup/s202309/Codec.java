package daydayup.s202309;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    public static final String NULL = "N";
    public static final String SPLIT_CHAR = ",";

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        deepFor(root, sb);
        String ans = sb.toString();
        return ans.substring(1);
    }

    public void deepFor(TreeNode root, StringBuilder sb) {
        if (null == root) {
            sb.append(SPLIT_CHAR).append(NULL);
            return;
        }
        sb.append(SPLIT_CHAR).append(root.val);
        deepFor(root.left, sb);
        deepFor(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        String[] split = data.split(SPLIT_CHAR);
        if (NULL.equals(split[0])) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        int i = desFor(root, split, 1, true);
        desFor(root, split, i + 1, false);
        return root;
    }

    public int desFor(TreeNode root, String[] split, int index, boolean lr) {
        if (index >= split.length) {
            return index;
        }
        if (NULL.equals(split[index])) {
            return index;
        }
        TreeNode node = new TreeNode(Integer.parseInt(split[index]));
        if (lr) {
            root.left = node;
        } else {
            root.right = node;
        }
        int i = desFor(node, split, index + 1, true);
        return desFor(node, split, i + 1, false);
    }
}
