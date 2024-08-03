package maksym.preparation.hard;

import maksym.preparation.util.Util;

import java.util.Deque;
import java.util.LinkedList;

public class CreateMaximumNumber {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        final int m = nums1.length;
        final int n = nums2.length;
        int[] res = new int[k];
        int leftBound = Math.max(k - n, 0);
        int rightBound = Math.min(m, k);

        for (int capacity = leftBound; capacity <= rightBound; capacity++) {
            int[] seq1 = maxSubSeq(nums1, capacity);
            int[] seq2 = maxSubSeq(nums2, k - capacity);
            int[] merged = merge(seq1, seq2);
            if (grater(merged, res, 0, 0)) res = merged;
        }
        return res;
    }

    public boolean grater(int[] arr1, int[] arr2, int i, int j) {
        int n = Math.min(arr1.length - i, arr2.length - j);
        for (int k = 0; k < n; k++) {
            if (arr1[i + k] < arr2[j + k]) return false;
            else if (arr1[i + k] > arr2[j + k]) return true;
         }
        return arr1.length - i > arr2.length - j;
    }

    public int[] merge(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length || j < arr2.length) {
            if (grater(arr1, arr2, i, j)) {
                res[k++] = arr1[i++];
            } else res[k++] = arr2[j++];
        }
        return res;
    }

    public int[] maxSubSeq(int[] arr, int k) {
        if (k >= arr.length) return arr;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() < arr[i] && arr.length - i > k - stack.size()) stack.pop();
            stack.push(arr[i]);
        }
        int[] subsequence = new int[k];
        for (int i = 0; i < subsequence.length; i++) {
            subsequence[i] = stack.pollLast();
        }
        return subsequence;
    }

    public static void main(String[] args) {
        CreateMaximumNumber instance = new CreateMaximumNumber();
        int[] nums1 = new int[]{3, 4, 6, 5};
        int[] nums2 = new int[]{9, 1, 2, 5, 8, 3};
        Util.show(instance.maxNumber(nums1, nums2, 5));

        int[] nums3 = new int[]{2,5,6,4,4,0};
        int[] nums4 = new int[]{7,3,8,0,6,5,7,6,2};
        Util.show(instance.maxNumber(nums3, nums4, 15));
    }
}
