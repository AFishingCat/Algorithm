package com.school.algorithm.randomquicksort;

import java.io.*;

/**
 * 随机快速排序
 * 涵盖荷兰国旗（三分区）问题
 * @author 黄兴鑫
 * @since 2024/10/16 20:39
 */
public class RandomQuickSort {
    private static final int MAX_LEN = 100001;
    private static final int[] target = new int[MAX_LEN];
    private static int left;
    private static int right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        int len = (int)in.nval;
        int token;
        for (int i = 0; (token = in.nextToken()) != StreamTokenizer.TT_EOF; i++) {
            if (token == StreamTokenizer.TT_NUMBER) target[i] = (int)in.nval;
        }
        randomQuickSort(0, len - 1);
        for (int i = 0; i < len - 1; i++) {
            out.print(target[i] + " ");
        }
        out.print(target[len - 1]);
        out.flush();
        out.close();
        br.close();
    }

    public static void randomQuickSort(int l, int r) {
        if (l >= r) {
            return;
        }
        int randLoc = l + (int)(Math.random() * (r - l + 1));
        partition(l, r, randLoc);
        int a = left - 1;
        int b = right + 1;
        randomQuickSort(l, a);
        randomQuickSort(b, r);
    }

    private static void partition(int l, int r, int randLoc) {
        int less = l;
        int grater = r;
        int i = l;
        int benchmark = target[randLoc];
//        3 5 2 5 5 6 5 7
//            a
//                      b
//                  i
//        解释 i<=grater
        while(i <= grater) {
            if (target[i] < benchmark) {
                swap(i++, less++);
            } else if (target[i] == benchmark) {
                i++;
            } else {
                swap(i, grater--);
            }
        }
        left = less;
        right = grater;
    }

    private static void swap(int locA, int locB) {
        int temp = target[locA];
        target[locA] = target[locB];
        target[locB] = temp;
    }
}
