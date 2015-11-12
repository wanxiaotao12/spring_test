package com.base.encoding;

/**
 * Created by hongming on 2015/8/9.
 */
public class Test {

    private String str="中国";

    public static void main(String[] args) {
        String a ="中国";
    }

    @org.junit.Test
    public void test(){
        System.out.println(toUnicode("中国"));
    }

    public static String toUnicode(String s) {
        String s1 = "";
        for (int i = 0; i < s.length(); i++) {
            s1 +="\\u" +  Integer.toHexString(s.charAt(i) & 0xffff);

        }
        return s1;
    }
}
