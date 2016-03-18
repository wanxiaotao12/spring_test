package com.base;

import org.junit.Test;

/**
 * @author wanxiaotao
 * @since 2016-03-18 10:31
 */
public class JsonFormatUtil {

    @Test
    public void test() {
        String jsonStr = "{\"paymentId\":\"8a839488532606b901532dee15e54bcc\",\"outBizId\":\"HJD9500500212\",\"errorMsg\":\"Transaction succeeded, risk after payment rejected\",\"errorCode\":\"000.400.100\",\"responseTime\":\"2016-03-01 00:48:17\",\"responseContent\":\"{\\\"id\\\":\\\"8a839488532606b901532dee15e54bcc\\\",\\\"paymentType\\\":\\\"PA\\\",\\\"amount\\\":\\\"0.08\\\",\\\"currency\\\":\\\"USD\\\",\\\"descriptor\\\":\\\"Ali*AliCloud.com\\\",\\\"merchantTransactionId\\\":\\\"HJD9500500212\\\",\\\"result\\\":{\\\"avsResponse\\\":\\\"U\\\",\\\"code\\\":\\\"000.400.100\\\",\\\"description\\\":\\\"Transaction succeeded, risk after payment rejected\\\"},\\\"buildNumber\\\":\\\"c8545431160a5cfb080256247c9c624a04daaeb6@2016-02-25 10:28:32 +0000\\\",\\\"timestamp\\\":\\\"2016-02-29 16:48:17+0000\\\",\\\"ndc\\\":\\\"8a8394c650aa39730150ad920a671fca_6434ff1f65eb49e9bbf502a7edd7521b\\\"}\",\"status\":\"Fail\"}";

        System.out.println(format(jsonStr));
    }


    public static String format(String jsonStr) {
        int level = 0;
        StringBuffer jsonForMatStr = new StringBuffer();
        for (int i = 0; i < jsonStr.length(); i++) {
            char c = jsonStr.charAt(i);
            if (level > 0 && '\n' == jsonForMatStr.charAt(jsonForMatStr.length() - 1)) {
                jsonForMatStr.append(getLevelStr(level));
            }
            switch (c) {
                case '{':
                case '[':
                    jsonForMatStr.append(c + "\n");
                    level++;
                    break;
                case ',':
                    jsonForMatStr.append(c + "\n");
                    break;
                case '}':
                case ']':
                    jsonForMatStr.append("\n");
                    level--;
                    jsonForMatStr.append(getLevelStr(level));
                    jsonForMatStr.append(c);
                    break;
                default:
                    jsonForMatStr.append(c);
                    break;
            }
        }

        return jsonForMatStr.toString();

    }

    private static String getLevelStr(int level) {
        StringBuffer levelStr = new StringBuffer();
        for (int levelI = 0; levelI < level; levelI++) {
            levelStr.append("\t");
        }
        return levelStr.toString();
    }

}
