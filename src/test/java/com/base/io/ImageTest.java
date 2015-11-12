package com.base.io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by hongming on 2015/8/9.
 */
public class ImageTest {
    @Test
    public void test() throws Exception{
        File file = new File("d:/iofile/test.png");
        FileInputStream fis = new FileInputStream(file); //创建一个输入流
        //创建一个输出流，后面一个参数true表示追加，原有内容不会被清除,默认为false
        FileOutputStream fos = new FileOutputStream("d:/iofile/test2.png",false);
        int ch = 0;
        //方式一
        /*while((ch=fis.read()) != -1){
            fos.write(ch);
        }*/
        //方式二
        byte[] b = new byte[1024];
        while((ch=fis.read(b)) != -1){
            fos.write(b,0,ch);
        }
        //方式三
//        byte[] b = new byte[fis.available()];
//        fis.read(b); //首先把fis的内容读到字节数组b里面
//        fos.write(b);//再把字节数组b的内容通过输出流写到指定文件
        //关闭流
        fos.close();
        fis.close();
    }


}
