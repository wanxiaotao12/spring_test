package com.base.io;

import org.junit.Test;

import java.io.*;

/**
 * Created by hongming on 2015/8/9.
 */
public class DataStreamTest {

    @Test
    public void test() throws Exception{
        // �ڵ���FileOutputStreamֱ����A.txt��Ϊ����Դ����
        FileOutputStream fileOutputStream = new FileOutputStream("A.txt");

        // ������BufferedOutputStream��һ��װ�νڵ������ṩ����д
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                fileOutputStream);

        // ������DataOutputStream��һ��װ�ι�������ʹ���ṩ�����������͵�д
        DataOutputStream out = new DataOutputStream(bufferedOutputStream);
        out.writeInt(3);
        out.writeBoolean(true);
        out.flush();
        out.close();
        // �˴�����ڵ��������������ø��ϱ������Ӧ�����߿ɾ�һ����
        DataInputStream in = new DataInputStream(new BufferedInputStream(
                new FileInputStream("A.txt")));
        System.out.println(in.readInt());
        System.out.println(in.readBoolean());
        in.close();
    }
}
