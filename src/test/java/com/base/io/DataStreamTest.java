package com.base.io;

import org.junit.Test;

import java.io.*;

/**
 * Created by hongming on 2015/8/9.
 */
public class DataStreamTest {

    @Test
    public void test() throws Exception{
        // 节点流FileOutputStream直接以A.txt作为数据源操作
        FileOutputStream fileOutputStream = new FileOutputStream("A.txt");

        // 过滤流BufferedOutputStream进一步装饰节点流，提供缓冲写
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                fileOutputStream);

        // 过滤流DataOutputStream进一步装饰过滤流，使其提供基本数据类型的写
        DataOutputStream out = new DataOutputStream(bufferedOutputStream);
        out.writeInt(3);
        out.writeBoolean(true);
        out.flush();
        out.close();
        // 此处输入节点流，过滤流正好跟上边输出对应，读者可举一反三
        DataInputStream in = new DataInputStream(new BufferedInputStream(
                new FileInputStream("A.txt")));
        System.out.println(in.readInt());
        System.out.println(in.readBoolean());
        in.close();
    }
}
