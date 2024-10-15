package com.school.algorithm.merge;

import java.io.*;

/**
 * 归并分支经典数组求解小和
 * @author 黄兴鑫
 * @since 2024/10/15 21:32
 */
public class SmallSum {
    private static final int MAX_SIZE = 100001;
    private static final int[] target = new int[MAX_SIZE];
    private static final int[] temp = new int[MAX_SIZE];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        int len = (int)in.nval;
        for (int i = 0, token; (token = in.nextToken()) != StreamTokenizer.TT_EOF; i++) {
            if (token == StreamTokenizer.TT_NUMBER) {
                target[i] = (int)in.nval;
            }
        }
        long answer = smallSum(0, len - 1);
        out.print(answer);
        out.flush();
        out.close();
        br.close();
    }

    private static long smallSum(int l, int r) {
        if (l == r) {
            return 0;
        }
        int m = l + (r - l) >> 1;
        return  smallSum(l, m) + smallSum(m + 1, r) + merge(l, m, r);
    }

    private static long merge(int l, int m, int r) {
        int a = l;
        int b = m + 1;
        long innerSum = 0;
        long sum = 0;
        while (b <= r) {
            while (target[a] <= target[b] && a < m + 1) {
                innerSum += target[a++];
            }
            sum += innerSum;
            b++;
        }

        a = l;
        b = m + 1;
        int i = l;
        while (a <= m && b <= r) {
            temp[i++] = target[a] <= target[b] ? target[a++] : target[b++];
        }
        while (a > m && i <= r) {
            temp[i++] = target[b++];
        }
        while (b > r && i <= r) {
            temp[i++] = target[a++];
        }
        while (l <= r) {
            target[l] = temp[l++];
        }
        return sum;
    }
}
