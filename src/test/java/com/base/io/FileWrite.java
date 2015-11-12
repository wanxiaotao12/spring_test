package com.base.io;


import org.junit.Test;

import java.io.*;

/**
 * Created by hongming on 2015/7/23.
 */
public class FileWrite {

    /**
     * 字节
     *
     * 写入字节，或字节数组
     *
     * @throws Exception
     */
    @Test
    public void testWrite() throws Exception {
        byte[] aa = "abcedfeg".toString().getBytes("UTF-8");

        FileOutputStream outputStream = new FileOutputStream("velocity.txt");
        for (byte b : aa) {
            outputStream.write(b);
        }
        outputStream.flush();
        outputStream.close();
    }


    /**
     * 文件写到了工程的要目录下
     *
     * @throws Exception
     */
    @Test
    public void testWriter() throws Exception {
        String s = "hello world";

        FileWriter fw = new FileWriter("hello.txt");

        fw.write(s, 0, s.length());
        fw.flush();
        fw.close();

        //字节流、字符流的转换
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("hello2.txt"));
        osw.write(s, 0, s.length());
        osw.flush();
        osw.close();

        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("hello3.txt")), true);
        pw.println(s);
        pw.close();
    }



    /**
     * BufferedWriter
     * 写一行， 换行：a、newLine()  b、\r\n
     * 1、字节流
     * 2、字节流转换为字符流
     * 3、字符流包装
     *
     * @throws Exception
     */
    @Test
    public void testWriteFile1() throws Exception {
        File file = new File("output1.txt");
        file.createNewFile(); // 创建新文件

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        //OutputStreamWriter 是字节流与字符的转换
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);

        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        bufferedWriter.write("你好");
        bufferedWriter.newLine();
        bufferedWriter.write("你也好\r\n 是的");
        bufferedWriter.close(); // 最后记得关闭文件
    }

    /**
     * 直接使用FileWriter
     *
     * @throws Exception
     */
    @Test
    public void testWriteFile2() throws Exception {
        File writename = new File("output2.txt");
        writename.createNewFile(); //

        BufferedWriter out = new BufferedWriter(new FileWriter(writename));
        out.write("我会写入文件啦\r\n"); // \r\n即为换行
        out.flush();
        out.close();
    }

    /**
     * PrintWriter
     * @throws Exception
     */
    @Test
    public void testPrintWriter() throws Exception {
        File file = new File("d:/iofile/output3.txt");
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file)));

        printWriter.write("第一行");
        printWriter.println(" abc");
        printWriter.println("第二行");

        printWriter.flush();
        printWriter.close();
    }


}
