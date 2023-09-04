package daydayup.s202309;

public class Solution01 {

    public static void main(String[] args) {
        int[][] ops = new int[][]{{2,2},{3,3}};
//        System.out.println(waysToBuyPensPencils(1000000, 1, 1));
        System.out.println(maxCount(3, 3, ops));
    }

    /**
     * 2240. 买钢笔和铅笔的方案数
     *
     * 给你一个整数 total ，表示你拥有的总钱数。同时给你两个整数 cost1 和 cost2 ，分别表示一支钢笔和一支铅笔的价格。你可以花费你部分或者全部的钱，去买任意数目的两种笔。
     *
     * 请你返回购买钢笔和铅笔的 不同方案数目 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：total = 20, cost1 = 10, cost2 = 5
     * 输出：9
     * 解释：一支钢笔的价格为 10 ，一支铅笔的价格为 5 。
     * - 如果你买 0 支钢笔，那么你可以买 0 ，1 ，2 ，3 或者 4 支铅笔。
     * - 如果你买 1 支钢笔，那么你可以买 0 ，1 或者 2 支铅笔。
     * - 如果你买 2 支钢笔，那么你没法买任何铅笔。
     * 所以买钢笔和铅笔的总方案数为 5 + 3 + 1 = 9 种。
     * 示例 2：
     *
     * 输入：total = 5, cost1 = 10, cost2 = 10
     * 输出：1
     * 解释：钢笔和铅笔的价格都为 10 ，都比拥有的钱数多，所以你没法购买任何文具。所以只有 1 种方案：买 0 支钢笔和 0 支铅笔。
     *
     *
     * 提示：
     *
     * 1 <= total, cost1, cost2 <= 106
     *
     */
    public static long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long pen = 0;
        long ans = 0;
        while (pen * cost1 <= total) {
            long i = (total - pen * cost1) / cost2;
            ans += i + 1;
            pen++;
        }
        return ans;
    }

    /**
     * 给你一个 m x n 的矩阵 M ，初始化时所有的 0 和一个操作数组 op ，其中 ops[i] = [ai, bi] 意味着当所有的 0 <= x < ai 和 0 <= y < bi 时， M[x][y] 应该加 1。
     *
     * 在 执行完所有操作后 ，计算并返回 矩阵中最大整数的个数 。
     *
     * 示例 1:
     *
     *
     *
     * 输入: m = 3, n = 3，ops = [[2,2],[3,3]]
     * 输出: 4
     * 解释: M 中最大的整数是 2, 而且 M 中有4个值为2的元素。因此返回 4。
     * 示例 2:
     *
     * 输入: m = 3, n = 3, ops = [[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3]]
     * 输出: 4
     * 示例 3:
     *
     * 输入: m = 3, n = 3, ops = []
     * 输出: 9
     * 提示:
     *
     * 1 <= m, n <= 4 * 104
     * 0 <= ops.length <= 104
     * ops[i].length == 2
     * 1 <= ai <= m
     * 1 <= bi <= n
     * Related Topics
     * 数组
     * 数学
     */
    public static int maxCount(int m, int n, int[][] ops) {
        int l = m, r = n;
        for (int[] op : ops) {
            if (op[0] < l) {
                l = op[0];
            }
            if (op[1] < r) {
                r = op[1];
            }
        }
        return l * r;
    }

    /**
     * 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
     *
     * 示例 1：
     *
     * 输入：nums = [12,345,2,6,7896]
     * 输出：2
     * 解释：
     * 12 是 2 位数字（位数为偶数）
     * 345 是 3 位数字（位数为奇数）
     * 2 是 1 位数字（位数为奇数）
     * 6 是 1 位数字 位数为奇数）
     * 7896 是 4 位数字（位数为偶数）
     * 因此只有 12 和 7896 是位数为偶数的数字
     * 示例 2：
     *
     * 输入：nums = [555,901,482,1771]
     * 输出：1
     * 解释：
     * 只有 1771 是位数为偶数的数字。
     * 提示：
     *
     * 1 <= nums.length <= 500
     * 1 <= nums[i] <= 10^5
     * Related Topics
     * 数组
     *
     */
    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] >= 10 && nums[i] < 100) || (nums[i] >= 1000 && nums[i] < 10000) || nums[i] == 100000) {
                ans++;
            }
        }
        return ans;
    }
}
