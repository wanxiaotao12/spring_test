package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by hongming on 2015/10/11.
 */
public class HelloWorldAspect {

    public void before(){
        System.out.println("************before***************");
    }

    public void after(){
        System.out.println("************after***************");
    }


    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("************around before***************");
        Object[] args = joinPoint.getArgs();

        Object result =  joinPoint.proceed(args);

        System.out.println("************around after***************");

        return result;
    }
}
