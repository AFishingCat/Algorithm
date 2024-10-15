package com.school.algorithm.ioprocessing;

import java.io.*;

/**
 * 算法笔试输入输出处理
 * @author 黄兴鑫
 * @since 2024/10/13
 */
public class ReadWriteProcess {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken() != StreamTokenizer.TT_EOF) {
            double i = in.nval;
            out.println(i);
        }
        br.close();
        out.close();
    }
}
