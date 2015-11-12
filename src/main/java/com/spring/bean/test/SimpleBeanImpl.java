package com.spring.bean.test;

import org.springframework.beans.factory.BeanFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by xiaotao.wxt on 2014/8/7.
 */
public class SimpleBeanImpl {
    private String strValue;
    private int intValue;
    private List<String> listValue;
    private Set<String> setValue;
    private String[] arrayValue;
    private Map mapValue;

    private BeanFactory factory;
    public void test(){
        factory.getBean("bean123");
    }

    public void say(){
        System.out.println("hello world");
    }


    public String getStrValue() {
        return strValue;
    }

    public void setStrValue(String strValue) {
        this.strValue = strValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public List<String> getListValue() {
        return listValue;
    }

    public void setListValue(List<String> listValue) {
        this.listValue = listValue;
    }

    public Set<String> getSetValue() {
        return setValue;
    }

    public void setSetValue(Set<String> setValue) {
        this.setValue = setValue;
    }

    public String[] getArrayValue() {
        return arrayValue;
    }

    public void setArrayValue(String[] arrayValue) {
        this.arrayValue = arrayValue;
    }

    public Map getMapValue() {
        return mapValue;
    }

    public void setMapValue(Map mapValue) {
        this.mapValue = mapValue;
    }

    @Override
    public String toString() {
        return "SimpleBeanImpl{" +
                "strValue='" + strValue + '\'' +
                ", intValue='" + intValue + '\'' +
                ", listValue=" + listValue +
                ", setValue=" + setValue +
                ", arrayValue=" + Arrays.toString(arrayValue) +
                ", mapValue=" + mapValue +
                '}';
    }

//    @Override
    public void sayHi() {
        System.out.println(toString());
    }
}
