package com.template;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.StringWriter;
import java.util.Properties;

/**
 * Created by hongming on 2015/7/23.
 */
public class TemplateTest {

    @Test
    public  void test() {
        render("template/template.vm");
    }


    public static void render(String templateName) {

        try {
            // 初始化并取得Velocity引擎
            VelocityEngine velocityEngine = new VelocityEngine();
            Properties properties =new Properties();
            properties.setProperty("resource.loader", "class");
            properties.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

            velocityEngine.init(properties);

            //取得velocity的模版
            Template template = velocityEngine.getTemplate(templateName,"utf-8");

            // 取得velocity的上下文context
            VelocityContext context = new VelocityContext();

            // 把数据填入上下文
            context.put("userName", "zhangsan");
            context.put("address", "beijing");


            // 输出流
            StringWriter writer = new StringWriter();
            // 转换输出
            template.merge(context, writer);
            // 输出信息
            System.out.println(writer.toString());

            // 输出到文件
            FileOutputStream of = new FileOutputStream("d:/velocity.txt");
            of.write(writer.toString().getBytes("UTF-8"));
            of.flush();
            of.close();
        } catch(Exception ex) {
            ex.printStackTrace();

        }

    }




}
