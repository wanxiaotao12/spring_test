package com.spring.bean.test;

/**
 * Created by xiaotao.wxt on 2014/8/13.
 */
public class SimpleBean2 {
    private OtherBean otherBean;

    public void test(){
        getOtherBean().test();
    }
    public OtherBean getOtherBean() {
        return otherBean;
    }

    public void setOtherBean(OtherBean otherBean) {
        this.otherBean = otherBean;
    }
}
