package com.base.reflection;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 第三方接口
 * Created by wanxiaotao on 15/10/16.
 */
public class MethodUtils {

    private static Logger logger = LoggerFactory.getLogger(MethodUtils.class);
    private static Map<String,Method>  methodMap = new ConcurrentHashMap<String, Method>();

    protected <T> T callRemoteInterface(String methodName, Object instance, Object... params) {
        T result = null;
        Method method = null;

        try {

            method = MethodUtils.getMethod(methodName, instance, params);


            result = (T)method.invoke(instance, params);

            if (result == null) {
                logger.error("callRemoteInterface error：return value is null, " + getMethodInfo(method, params));
            } else {
                logger.info("callRemoteInterface " + getMethodInfo(method, params) + ", result =" + JSON.toJSONString(result));

                //判断返回数据中的属性值是否成功
                Class returnClass = method.getReturnType();
                Method successMethod = returnClass.getMethod("isSuccess");
                boolean successResult = (Boolean) successMethod.invoke(result);

            }

        } catch (Exception ex) {
            logger.error("callRemoteInterface exception, " + getMethodInfo(method, params), ex);
        }

        return result;
    }

    private String getMethodInfo(Method method, Object params) {
        return method.getDeclaringClass() + "." + method.getName() + ", params=" + JSON.toJSONString(params);
    }


    public static synchronized Method getMethod(String methodName,Object instance,Object... params){
        String className = instance.getClass().getName();

        Method method = null;
        if(methodMap.get(className+methodName) == null) {
            try {
                if(ArrayUtils.isEmpty(params)) {
                    method = instance.getClass().getMethod(methodName);
                } else  {
                    Class[] classes = new Class[params.length];
                    for(int i=0;i<params.length;i++) {
                        classes[i] = params[i].getClass();
                    }
                    method = instance.getClass().getMethod(methodName,classes);

                }


                methodMap.put(getClassMethod(className,methodName), method);
            } catch (Exception ex) {
                ex.printStackTrace();
                logger.error("getMethod error, methodName="+methodName + ", instatnce=" +instance + ", param=" + JSON.toJSONString(params),ex);
            }
        } else {
            methodMap.get(getClassMethod(className,methodName));
        }


        return method;
    }

    private static String getClassMethod(String className,String methodName){
       return className+"."+methodName;
    }


    public String add(String param, Integer param2) {
        return param + "," + param2.toString();
    }

    public void add2() {
      System.out.println("*****add2()*****");
    }

    public String add3(String str) {
        System.out.println("*****add3()*****");

        return str + "**";
    }

    public static void main(String[] args) throws  Exception{
        MethodUtils methodUtils = new MethodUtils();

        Object[] params = new Object[]{"abc",12};

        Method method = MethodUtils.getMethod("add", methodUtils, params);
        Object obj = method.invoke(methodUtils, params);
        System.out.println(obj);


        Method method2 = MethodUtils.getMethod("add2", methodUtils);
        Object obj2 = method2.invoke(methodUtils);

        System.out.println("obj2="+ obj2);


        Method method3 = MethodUtils.getMethod("add3", methodUtils,"abc");
        Object obj3 = method3.invoke(methodUtils,"abc");

        System.out.println("obj3="+ obj3);

    }

}
