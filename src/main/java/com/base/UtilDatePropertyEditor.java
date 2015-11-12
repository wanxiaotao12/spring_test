package com.base;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * java.util.Date 属性编辑器, PropertyEditorSupport是jdk中的类
 * @author wanxiaotao
 *
 */
public class UtilDatePropertyEditor extends PropertyEditorSupport {
    String format = "yyyy-MM-dd HH:mm:ss";
    @Override
    public void setAsText(String  text) throws IllegalArgumentException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            Date date = sdf.parse(text);
            //调用父类的方法， 为value属性设值
            this.setValue(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
