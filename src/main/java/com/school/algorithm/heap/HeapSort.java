package com.school.algorithm.heap;

import java.io.*;

/**
 * 利用堆结构进行排序
 *
 * @author 黄兴鑫
 * @since 2024/10/18 20:49
 */
public class HeapSort {
    private static final int MAX_LEN = 500001;
    private static final int[] target = new int[MAX_LEN];
    private static int heapSize;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        n = (int)in.nval;
        int token;
        int i = 0;
        while ((token = in.nextToken()) != StreamTokenizer.TT_EOF) {
            if (token == StreamTokenizer.TT_NUMBER) {
                target[i++] = (int)in.nval;
            }
        }
        heapsort();
        for (int j = 0; j < n - 1; j++) {
            out.print(target[j] + " ");
        }
        out.print(target[n - 1]);
        out.flush();
        out.close();
        br.close();
    }
    private static void swap(int locA, int locB) {
        int temp = target[locA];
        target[locA] = target[locB];
        target[locB] = temp;
    }

    private static void heapInsert(int i) {
        int parent;
        while (target[i] > target[parent = (i - 1) / 2]) {
            swap(i, parent);
            i = parent;
        }
        heapSize++;
    }

    private static void heapify(int i) {
        int l = i * 2 + 1;
        while (l < heapSize) {
            int maxLoc = l + 1 < heapSize && target[l + 1] > target[l] ? l + 1 : l;
            maxLoc = target[i] > target[maxLoc] ? i : maxLoc;
            if (maxLoc == i) break;
            swap(i, maxLoc);
            i = maxLoc;
            l = i * 2 + 1;
        }
    }

    private static void heapsort() {
//      将初始状态视作完全二叉树，自底向上构建堆
        heapSize = n;
        for (int j = n - 1; j >= 0; j--) {
            heapify(j);
        }
        for (int i = n - 1; i >= 0; i--) {
            swap(0, i);
            heapSize--;
            heapify(0);
        }
    }

    private static void heapsort0() {
//      从0开始自定向下构建堆
        for (int i = 0; i < n; i++) {
            heapInsert(i);
        }
        for (int i = n - 1; i >= 0; i--) {
            swap(0, i);
            heapSize--;
            heapify(0);
        }
    }
}
