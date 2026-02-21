package maksym.preparation.hard.dp;

import java.util.ArrayList;

public class MinimumNumberOfRemovalsToMakeMountain {
    public int minimumMountainRemovals(int[] nums) {
        final int N = nums.length;

        int[] leftLis = lis(nums);

        reverse(nums);
        int[] rightLis = lis(nums);
        reverse(rightLis);

        var minRem = Integer.MAX_VALUE;

        for (int i = 1; i < N - 1; i++) {
            var leftRem = i - leftLis[i] + 1;
            var rightRem = N - i - rightLis[i];

            if (leftRem != i && rightRem != N - i - 1) {
                minRem = Math.min(leftRem + rightRem, minRem);
            }
        }

        return minRem;
    }

    private void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    private int[] lis(int[] arr) {
        final int N = arr.length;
        var seq = new ArrayList<Integer>();
        var ans = new int[N];

        for (int i = 0; i < N; i++) {
            var value = arr[i];

            if (seq.isEmpty() || seq.get(seq.size() - 1) < value) {
                seq.add(value);
                ans[i] = seq.size();
            }
            if (value < seq.get(0)) {
                seq.set(0, value);
                ans[i] = 1;
            } else {
                var l = 0;
                var r = seq.size() - 1;
                while (l < r) {
                    int m = l + (r - l) / 2;
                    if (seq.get(m) < value) {
                        l = m + 1;
                    } else {
                        r = m;
                    }
                }

                seq.set(l, value);
                ans[i] = l + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        var o = new MinimumNumberOfRemovalsToMakeMountain();
        System.out.println(o.minimumMountainRemovals(new int[]{1, 2, 1, 3, 4, 4}));
        System.out.println(o.minimumMountainRemovals(new int[]{100, 92, 89, 77, 74, 66, 64, 66, 64}));
        System.out.println(o.minimumMountainRemovals(new int[]{9, 8, 1, 7, 6, 5, 4, 3, 2, 1}));
        System.out.println(o.minimumMountainRemovals(new int[]{2, 1, 1, 5, 6, 2, 3, 1}));
    }
}
