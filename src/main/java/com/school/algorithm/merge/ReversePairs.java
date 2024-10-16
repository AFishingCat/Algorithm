package com.school.algorithm.merge;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class ReversePairs {
    private static final int MAX_LEN = 5001;
    private static final long[] target = new long[MAX_LEN];
    private static final long[] temp = new long[MAX_LEN];

    public static int reversePairs(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            target[i] = nums[i];
        }
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        out.print(numOfReversePairs(0, nums.length - 1));
        out.flush();
        out.close();
        return 0;
    }

    public static int numOfReversePairs(int l, int r) {
        if (l >= r) {
            return 0;
        }
        int m = l + (r - l) / 2;
        return numOfReversePairs(l, m) + numOfReversePairs(m + 1, r) + merge(l, m, r);
    }

    //    1 3 7 1 2 3
//    a
//          b
//    2 + 1 + 1 = 4
    private static int merge(int l, int m, int r) {
        int a = l;
        int b = m + 1;
        int sum = 0;
        while (a < m + 1 && b <= r) {
            if (target[a] > 2 * target[b]) {
                sum += m - a + 1;
                b++;
            } else {
                a++;
            }
        }
        a = l;
        b = m + 1;
        int i = l;
        while (a <= m && b <= r) {
            temp[i++] = target[a] <= target[b] ? target[a++] : target[b++];
        }
        while (b <= r) {
            temp[i++] = target[b++];
        }
        while (a <= m) {
            temp[i++] = target[a++];
        }
        while (l <= r) {
            target[l] = temp[l++];
        }
        return sum;
    }
}
