package com.base.encoding;

import org.junit.Test;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.SortedMap;

/**
 * Created by hongming on 2015/8/9.
 */
public class EncodingTest {

    /**
     * unicode是16进制存储的，
     */
    @Test
    public void test2() {
        //\u4e2d\u56fd是unicode编码，代表“中国”
        System.out.println("\u4e2d\u56fd");
        //将一个字符转化为16进制字符串
        System.out.println(Integer.toHexString((char) '中'));
        //将一个字符，以16基数，将字符串参数解析为有符号的整数，然后再转化为char
        System.out.println((char) Integer.parseInt("4e2d", 16));
    }


    /**
     * JDK支持的字符集
     */
    @org.junit.Test
    public void testGetJavaAvailableCharsets() {
        SortedMap<String, Charset> map = Charset.availableCharsets();
        System.out.println("size = " + map.size());
        for (Map.Entry<String, Charset> entry : map.entrySet()) {
            System.out.println("key = " + entry.getKey() + ", value =" + entry.getValue());
        }
    }

    /**
     * 默认的字符集
     * <p/>
     * 从外部读取文件未指定编码方式， 但是是使用默认的编码方式
     * InputStreamReader streamReader = new InputStreamReader(is);
     * <p/>
     * 如：默认是utf-8，则外部文件也是utf-8，则不会乱码， 否则需要指定编码方式
     */
    @org.junit.Test
    public void testGetDefautlCharset() {
        Charset charset = Charset.defaultCharset();
        System.out.println("defautl charset = " + charset);
    }

    /**
     * unicode 码 转换成指定编码格式的字节数组
     * 字符串 - > 字节数组
     */
    @Test
    public void testChangeCharset() {
        //以下的两种方式是一样的, 参数为空，使用默认编码
        byte[] bytes = "String".getBytes();


        byte[] bytes2 = "String".getBytes(Charset.defaultCharset());

    }

    @Test
    public void getChanageToBytes() {
        String temp = new String("String".getBytes());
        String temp2 = new String("String".getBytes(), Charset.defaultCharset());
    }


    @Test
    public void test() throws Exception {
        String str = "中国";
        System.out.println("str.getBytes默认字符集：");
        for (byte b : str.getBytes()) {
            System.out.print(Integer.toHexString(b) + " ");
        }
        System.out.println("\n str.getBytes JVM默认字符集：" + Charset.defaultCharset());
        for (byte b : str.getBytes(Charset.defaultCharset())) {
            System.out.print(Integer.toHexString(b) + " ");
        }
        System.out.println("\n str.getBytes unicode字符集：");
        for (byte b : str.getBytes("unicode")) {
            System.out.print(Integer.toHexString(b) + " ");
        }
        System.out.println("\n 字符串对应的16进制");
        for (char b : str.toCharArray()) {
            System.out.println(Integer.toHexString(b));
        }
    }


}
