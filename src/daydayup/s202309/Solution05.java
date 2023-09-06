package daydayup.s202309;

import java.util.List;

public class Solution05 {

    public static void main(String[] args) {
//        String word = "ABCCED";
//        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "abcd";
        char[][] board = {{'a','b'},{'c','d'}};
        System.out.println();
    }

    public static int minNumber(int[] nums1, int[] nums2) {
        int nn = 10, mm = 10;
        int[] arr = new int[10];
        for (int i : nums1) {
            if (i < nn) {
                nn = i;
            }
            arr[i] += 1;
        }
        for (int i : nums2) {
            if (i < mm) {
                mm = i;
            }
            arr[i] += 1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 1) {
                return i;
            }
        }
        return nn > mm ? mm * 10 + nn : nn * 10 + mm;
    }


}
