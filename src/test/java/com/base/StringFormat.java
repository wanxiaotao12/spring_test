package com.base;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author wanxiaotao
 * @since 2016-02-22 14:21
 */
public class StringFormat {

    /**
     * 未满4位， 则补0
     */
    @Test public void test1() {
        System.out.println(String.format("%04d", Math.abs(2716804264L) % 1000));

        BigDecimal a = new BigDecimal(12.123);
        BigDecimal scaledBd = a.movePointRight(3);
        System.out.println(scaledBd.longValue());

    }
}
