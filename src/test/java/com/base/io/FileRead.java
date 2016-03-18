package com.base.io;

import org.junit.Test;

import java.io.*;

/**
 * Created by hongming on 2015/8/9.
 */
public class FileRead {
    /**
     * InputStream:���ֽ�Ϊ��λ��ȡ�ļ��������ڶ��������ļ�����ͼƬ��������Ӱ����ļ���
     * ��ȡ�� int ���͵ı����� Ȼ����ת��Ϊchar
     *
     * ���֣������룬��Ϊһ������ռ�������ֽ�
     */
    @Test
    public void readFileByBytes() {
        File file = new File("input.txt");
        InputStream in = null;
        try {
            System.out.println("���ֽ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���ֽڣ�");
            // һ�ζ�һ���ֽ�
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
     * InputStream: ��ȡ��һ��������С���ֽ�������
     *
     */
    @Test
    public void readFileByBytes2() {
        File file = new File("input.txt");
        InputStream in = null;
        try {
            System.out.println("���ֽ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���ֽڣ�");
            // һ�ζ�һ���ֽ�
            in = new FileInputStream(file);
            byte[] temp = new byte[1024];
            int tempbyte;
            while ((tempbyte = in.read(temp)) != -1) {
                for(int i= 0 ;i<tempbyte;i++) {
                    System.out.println((char)temp[i]);
                }
                System.out.println("ת��Ϊ�ֶδ���");
                System.out.println(new String(temp,0,tempbyte));
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * InputStreamReader:���ַ�Ϊ��λ��ȡ�ļ��������ڶ��ı������ֵ����͵��ļ�
     *
     * ͬʱҲ���ֽ����� ���ַ��е�ת��
     *
     * ���ֲ����������
     */
    @Test
    public void readFileByChars() {
        File file = new File("input.txt");
        Reader reader = null;
        try {
            System.out.println("���ַ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���ֽڣ�");
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                //����windows�£�rn�������ַ���һ��ʱ����ʾһ�����С�
                //������������ַ��ֿ���ʾʱ���ỻ�����С�
                //��ˣ����ε�r����������n�����򣬽������ܶ���С�
                if (((char) tempchar) != 'r') {
                    System.out.println((char) tempchar);
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println("���ַ�Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�����ֽڣ�");
            //һ�ζ�����ַ�
            char[] tempchars = new char[30];
            int charread = 0;
            reader = new InputStreamReader(new FileInputStream(file));
            //�������ַ����ַ������У�charreadΪһ�ζ�ȡ�ַ���
            while ((charread = reader.read(tempchars)) != -1) {
                //ͬ�����ε�r����ʾ
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
     * ����Ϊ��λ��ȡ�ļ��������ڶ������еĸ�ʽ���ļ�
     * BufferedReader
     */
    @Test
    public void readFileByLines() {
        File file = new File("input.txt");
        BufferedReader reader = null;
        try {
            System.out.println("����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���У�");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            //һ�ζ���һ�У�ֱ������nullΪ�ļ�����
            while ((tempString = reader.readLine()) != null) {
                //��ʾ�к�
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
     * 1���ֽ��� ���ַ���ת��
     * InputStreamReader
     * 2��ʹ��BufferedReader �ٽ��ַ�����װ�� һ��һ�еĶ�
     *
     * @throws Exception
     */
    @Test
    public void testReadFile() throws Exception {
        String pathname = "input.txt";
        File filename = new File(pathname);

        //InputStreamReader ���ֽ������ַ�����ת��
        InputStreamReader inputStreamReader = new InputStreamReader(
                new FileInputStream(filename)); //

        //��inputStreamReader�Ļ����װ
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = "";
        line = bufferedReader.readLine();
        while (line != null) {
            System.out.println(line);
            line = bufferedReader.readLine(); // һ�ζ���һ������
        }

    }

    /**
     * 1��ֱ��ʹ���ַ���  FileReader
     * 2�����ַ�����װ
     *
     * @throws Exception
     */
    @Test
    public void testReadFile2() throws Exception {
        String pathname = "D:/iofile/input.txt";
        File filename = new File(pathname);

        FileReader fileReader = new FileReader(filename);

        //��inputStreamReader�Ļ����װ
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = "";
        line = bufferedReader.readLine();
        while (line != null) {
            System.out.println(line);
            line = bufferedReader.readLine(); // һ�ζ���һ������
        }

    }

    /**
     * �����ȡ�ļ�����
     */
    @Test
    public void readFileByRandomAccess() {

        RandomAccessFile randomFile = null;
        try {
            System.out.println("�����ȡһ���ļ����ݣ�");
            // ��һ����������ļ�������ֻ����ʽ
            randomFile = new RandomAccessFile("input.txt", "r");
            // �ļ����ȣ��ֽ���
            long fileLength = randomFile.length();
            // ���ļ�����ʼλ��
            int beginIndex = (fileLength > 6) ? 6 : 0;
            //�����ļ��Ŀ�ʼλ���Ƶ�beginIndexλ�á�
            randomFile.seek(beginIndex);
            byte[] bytes = new byte[10];
            int byteread = 0;
            //һ�ζ�10���ֽڣ�����ļ����ݲ���10���ֽڣ����ʣ�µ��ֽڡ�
            //��һ�ζ�ȡ���ֽ�������byteread
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
     * ��ʾ�������л�ʣ���ֽ���
     *
     * @param in
     */
    private static void showAvailableBytes(InputStream in) {
        try {
            System.out.println("��ǰ�ֽ��������е��ֽ���Ϊ:" + in.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() throws Exception {
        String str = "�й�";
        //utf-8: һ������3���ֽڣ� gbk:һ������2���ֽ�
        byte[] bytes = str.getBytes("gbk");
        for (byte b : bytes) {
            System.out.println(b);
        }

    }


}
