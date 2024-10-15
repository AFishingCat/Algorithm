package com.school.algorithm.merge;

import java.io.*;

/**
 * 归并排序
 *
 * @author 黄兴鑫
 * @since 2024/10/14 20:49
 */
public class MergeSort {
    private static final int MAX_SIZE = 100001;
    private static final int[] target = new int[MAX_SIZE];
    private static final int[] temp = new int[MAX_SIZE];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        int len = (int) in.nval;
        for (int i = 0; i < len; i++) {
            in.nextToken();
            target[i] = (int) in.nval;
        }
        mergeSortByRec(0, len - 1);
        for (int i = 0; i < len - 1; i++) {
            out.print(target[i] + " ");
        }
        out.println(target[len - 1]);
        out.flush();
        out.close();
        br.close();
    }

    private static void mergeSortByRec(int l, int r) {
        if (l == r) {
            return;
        }
        int m = l + (r - l) / 2;
        mergeSortByRec(l, m);
        mergeSortByRec(m + 1, r);
        merge(l, m, r);
    }

    private static void merge(int l, int m, int r) {
        int a = l;
        int b = m + 1;
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
    }
}

