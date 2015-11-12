package com.spring.bean.test;

import java.util.Date;

/**
 * Created by xiaotao.wxt on 2014/8/13.
 */
public class SimpleBean4 {
    private Date createTime;

    public void test() {
        System.out.print("createTime=" + createTime);
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
