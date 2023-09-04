package daydayup.s202309;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution04 {
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
//        Codec ser = new Codec();
//        Codec deser = new Codec();
//        String tree = ser.serialize(root);
//        System.out.println(tree);
//        TreeNode ans = deser.deserialize(tree);
//        System.out.println(ser.serialize(ans));
        Solution04 s = new Solution04();
        TreeNode node = s.addOneRow(root, 10, 3);
        s.bfs(node);
    }

    //已知函数 signFunc(x) 将会根据 x 的正负返回特定值：
//
//
// 如果 x 是正数，返回 1 。
// 如果 x 是负数，返回 -1 。
// 如果 x 是等于 0 ，返回 0 。
//
//
// 给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。
//
// 返回 signFunc(product) 。
//
//
//
// 示例 1：
//
//
//输入：nums = [-1,-2,-3,-4,3,2,1]
//输出：1
//解释：数组中所有值的乘积是 144 ，且 signFunc(144) = 1
//
//
// 示例 2：
//
//
//输入：nums = [1,5,0,2,-3]
//输出：0
//解释：数组中所有值的乘积是 0 ，且 signFunc(0) = 0
//
//
// 示例 3：
//
//
//输入：nums = [-1,1,-1,1,-1]
//输出：-1
//解释：数组中所有值的乘积是 -1 ，且 signFunc(-1) = -1
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 1000
// -100 <= nums[i] <= 100
//
//
// Related Topics 数组 数学 👍 92 👎 0


    public int arraySign(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (0 == num) {
                return 0;
            }
            if (num < 0) {
                i++;
            }
        }
        return i % 2 == 0 ? 1 : -1;
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (null == root) {
            return new TreeNode(val);
        }
        if (1 == depth) {
            TreeNode newNode = new TreeNode(val);
            newNode.left = root;
            return newNode;
        }
        dfs(root, 1, val, depth);
        return root;
    }

    public void dfs(TreeNode root, int curDepth, int val, int depth) {
        if (null == root) {
            return;
        }
        System.out.println(root.val + " " + depth);
        if (curDepth == depth - 1) {
            TreeNode leftNode = new TreeNode(val);
            leftNode.left = root.left;
            root.left = leftNode;
            TreeNode rightNode = new TreeNode(val);
            rightNode.right = root.right;
            root.right = rightNode;
            return;
        }
        dfs(root.left, curDepth + 1, val, depth);
        dfs(root.right, curDepth + 1, val, depth);
    }

    private void bfs(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.val + " ");
            if (null != cur.left) {
                queue.offer(cur.left);
            }
            if (null != cur.right) {
                queue.offer(cur.right);
            }
        }
    }

}
