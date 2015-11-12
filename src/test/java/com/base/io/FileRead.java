package com.base.io;

import org.junit.Test;

import java.io.*;

/**
 * Created by hongming on 2015/8/9.
 */
public class FileRead {
    /**
     * InputStream:以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件。
     * 读取到 int 类型的变量， 然后再转化为char
     *
     * 汉字：会乱码，因为一个汉字占用两个字节
     */
    @Test
    public void readFileByBytes() {
        File file = new File("input.txt");
        InputStream in = null;
        try {
            System.out.println("以字节为单位读取文件内容，一次读一个字节：");
            // 一次读一个字节
            in = new FileInputStream(file);
            int tempbyte;
            while ((tempbyte = in.read()) != -1) {
                System.out.println((char) tempbyte);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * InputStream: 读取到一个给定大小的字节数组中
     *
     */
    @Test
    public void readFileByBytes2() {
        File file = new File("input.txt");
        InputStream in = null;
        try {
            System.out.println("以字节为单位读取文件内容，一次读一个字节：");
            // 一次读一个字节
            in = new FileInputStream(file);
            byte[] temp = new byte[1024];
            int tempbyte;
            while ((tempbyte = in.read(temp)) != -1) {
                for(int i= 0 ;i<tempbyte;i++) {
                    System.out.println((char)temp[i]);
                }
                System.out.println("转化为字段串：");
                System.out.println(new String(temp,0,tempbyte));
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * InputStreamReader:以字符为单位读取文件，常用于读文本，数字等类型的文件
     *
     * 同时也是字节流， 到字符中的转换
     *
     * 汉字不会出现乱码
     */
    @Test
    public void readFileByChars() {
        File file = new File("input.txt");
        Reader reader = null;
        try {
            System.out.println("以字符为单位读取文件内容，一次读一个字节：");
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                //对于windows下，rn这两个字符在一起时，表示一个换行。
                //但如果这两个字符分开显示时，会换两次行。
                //因此，屏蔽掉r，或者屏蔽n。否则，将会多出很多空行。
                if (((char) tempchar) != 'r') {
                    System.out.println((char) tempchar);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("以字符为单位读取文件内容，一次读多个字节：");
            //一次读多个字符
            char[] tempchars = new char[30];
            int charread = 0;
            reader = new InputStreamReader(new FileInputStream(file));
            //读入多个字符到字符数组中，charread为一次读取字符数
            while ((charread = reader.read(tempchars)) != -1) {
                //同样屏蔽掉r不显示
                if ((charread == tempchars.length) && (tempchars[tempchars.length - 1] != 'r')) {
                    System.out.print(tempchars);
                } else {
                    for (int i = 0; i < charread; i++) {
                        if (tempchars[i] == 'r') {
                            continue;
                        } else {
                            System.out.print(tempchars[i]);
                        }
                    }
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     * BufferedReader
     */
    @Test
    public void readFileByLines() {
        File file = new File("input.txt");
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            //一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                //显示行号
                System.out.println("line " + line + ": " + tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    /**
     * 1、字节流 向字符流转化
     * InputStreamReader
     * 2、使用BufferedReader 再将字符流包装， 一行一行的读
     *
     * @throws Exception
     */
    @Test
    public void testReadFile() throws Exception {
        String pathname = "input.txt";
        File filename = new File(pathname);

        //InputStreamReader 是字节流与字符流的转换
        InputStreamReader inputStreamReader = new InputStreamReader(
                new FileInputStream(filename)); //

        //对inputStreamReader的缓冲包装
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = "";
        line = bufferedReader.readLine();
        while (line != null) {
            System.out.println(line);
            line = bufferedReader.readLine(); // 一次读入一行数据
        }

    }

    /**
     * 1、直接使用字符流  FileReader
     * 2、将字符流封装
     *
     * @throws Exception
     */
    @Test
    public void testReadFile2() throws Exception {
        String pathname = "D:/iofile/input.txt";
        File filename = new File(pathname);

        FileReader fileReader = new FileReader(filename);

        //对inputStreamReader的缓冲包装
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = "";
        line = bufferedReader.readLine();
        while (line != null) {
            System.out.println(line);
            line = bufferedReader.readLine(); // 一次读入一行数据
        }

    }

    /**
     * 随机读取文件内容
     */
    @Test
    public void readFileByRandomAccess() {

        RandomAccessFile randomFile = null;
        try {
            System.out.println("随机读取一段文件内容：");
            // 打开一个随机访问文件流，按只读方式
            randomFile = new RandomAccessFile("input.txt", "r");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            // 读文件的起始位置
            int beginIndex = (fileLength > 6) ? 6 : 0;
            //将读文件的开始位置移到beginIndex位置。
            randomFile.seek(beginIndex);
            byte[] bytes = new byte[10];
            int byteread = 0;
            //一次读10个字节，如果文件内容不足10个字节，则读剩下的字节。
            //将一次读取的字节数赋给byteread
            while ((byteread = randomFile.read(bytes)) != -1) {
                System.out.write(bytes, 0, byteread);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomFile != null) {
                try {
                    randomFile.close();
                } catch (IOException e1) {
                }
            }
        }
    }


    /**
     * 显示输入流中还剩的字节数
     *
     * @param in
     */
    private static void showAvailableBytes(InputStream in) {
        try {
            System.out.println("当前字节输入流中的字节数为:" + in.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() throws Exception {
        String str = "中国";
        //utf-8: 一个汉字3个字节， gbk:一个汉字2个字节
        byte[] bytes = str.getBytes("gbk");
        for (byte b : bytes) {
            System.out.println(b);
        }

    }


}
