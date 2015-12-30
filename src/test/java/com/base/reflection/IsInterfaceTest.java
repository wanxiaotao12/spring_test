package com.base.reflection;

import com.user.impl.UserServiceImpl;
import org.junit.Test;

/**
 * Created by wanxiaotao on 30/12/15.
 */
public class IsInterfaceTest {
    @Test
    public void testIsInterface(){
        System.out.println(UserServiceImpl.class.isInterface());
        Class[] clazzes = UserServiceImpl.class.getInterfaces();

        for(Class clazz : clazzes) {
            System.out.println(clazz);
        }

    }

}
