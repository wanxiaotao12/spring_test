package com.assertTest;

import org.junit.Assert;

/**
 * Created by hongming on 2015/11/4.
 */
public class AssertTest {

    @org.junit.Test
    public void test(){
        Assert.assertNotNull("dd", null);
    }
}
