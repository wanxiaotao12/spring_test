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
        FileInputStream fis = new FileInputStream(file); //����һ��������
        //����һ�������������һ������true��ʾ׷�ӣ�ԭ�����ݲ��ᱻ���,Ĭ��Ϊfalse
        FileOutputStream fos = new FileOutputStream("d:/iofile/test2.png",false);
        int ch = 0;
        //��ʽһ
        /*while((ch=fis.read()) != -1){
            fos.write(ch);
        }*/
        //��ʽ��
        byte[] b = new byte[1024];
        while((ch=fis.read(b)) != -1){
            fos.write(b,0,ch);
        }
        //��ʽ��
        //        byte[] b = new byte[fis.available()];
        //        fis.read(b); //���Ȱ�fis�����ݶ����ֽ�����b����
        //        fos.write(b);//�ٰ��ֽ�����b������ͨ�������д��ָ���ļ�
        //�ر���
        fos.close();
        fis.close();
    }


}
