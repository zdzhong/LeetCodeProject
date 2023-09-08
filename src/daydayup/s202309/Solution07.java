package daydayup.s202309;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution07 {

    public static void main(String[] args) {
        int[] ranks = {2,3,4,5,1};
        int cars = 726824;
//        System.out.println(repairCars(ranks, cars));
//        System.out.println(findPeakElement(ranks));
//        System.out.println(findMin(ranks));

    }
//
//    public static long repairCars(int[] ranks, int cars) {
//        int[] rankArr = new int[ranks.length];
//        long ans = 0;
//        for (int i = 0; i < cars; i++) {
//            long temp = Long.MAX_VALUE;
//            int k = 0;
//            for (int j = 0; j < rankArr.length; j++) {
//                long prep = (long) rankArr[j] + 1;
//                long cur = (long) ranks[j] * prep * prep;
//                if (cur < temp) {
//                    k = j;
//                    temp = cur;
//                }
//            }
//            rankArr[k] += 1;
//        }
//        for (int i = 0; i < rankArr.length; i++) {
//            long cur = (long) ranks[i] * (long) rankArr[i] * (long) rankArr[i];
//            if (cur > ans) {
//                ans = cur;
//            }
//        }
//        return ans;
//    }

    // 2594 固定时间内，如果工人能供将所有车辆修完，那么缩短一半的时间，找出最短时间
    public static long repairCars(int[] ranks, int cars) {
        long left = 1, right = (long) ranks[0] * cars * cars;
        while (left < right) {
            long mid = (right + left) / 2;
            if (check(ranks, cars, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean check(int[] ranks, int cars, long mid) {
        // 固定时间内，工人可以修多少辆车 = sqrt(mid / rank)
        long cnt = 0;
        for (int rank : ranks) {
            cnt += (long) Math.sqrt(mid / rank);
        }
        // 判断固定时间内所有功能能修多少辆车
        return cnt >= cars;
    }

    // 34
    public static int[] searchRange(int[] nums, int target) {
        int start = lowBound(nums, target);
        if (start == nums.length || target != nums[start]) {
            return new int[]{-1, -1};
        }
        int end = lowBound(nums, target + 1) - 1;
        return new int[]{start, end};
    }

    private static int lowBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1; // 闭区间
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {   // nums[mid - 1]
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    // 162
    public static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 153
    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int pivot = nums[nums.length - 1];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > pivot) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);
        return nums[left];
    }

    // 33
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 判断哪边有序
            if (nums[0] <= nums[mid]) {
                // 左边有序
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 右边有序
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}
