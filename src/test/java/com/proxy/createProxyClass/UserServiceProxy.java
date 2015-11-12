package com.proxy.createProxyClass;

import com.user.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * 使用JDK的方式生成的代理类
 */
public final class UserServiceProxy extends Proxy implements UserService {
    private static Method m1;
    private static Method m0;
    private static Method m3;
    private static Method m2;

    public UserServiceProxy(InvocationHandler paramInvocationHandler) throws RuntimeException {
        super(paramInvocationHandler);
    }

    public final boolean equals(Object paramObject) throws RuntimeException {
        try {
            return ((Boolean) this.h.invoke(this, m1, new Object[] { paramObject })).booleanValue();
        } catch (RuntimeException localError) {
            throw localError;
        } catch (Throwable localThrowable) {
            throw new UndeclaredThrowableException(localThrowable);
        }
    }

    public final int hashCode() throws RuntimeException {
        try {
            return ((Integer) this.h.invoke(this, m0, null)).intValue();
        } catch (RuntimeException localError) {
            throw localError;
        } catch (Throwable localThrowable) {
            throw new UndeclaredThrowableException(localThrowable);
        }
    }

    public final void addUser() throws Error {
        try {
            this.h.invoke(this, m3, null);
            return;
        } catch (Error localError) {
            throw localError;
        } catch (Throwable localThrowable) {
            throw new UndeclaredThrowableException(localThrowable);
        }
    }

    public final String toString() throws Error {
        try {
            return (String) this.h.invoke(this, m2, null);
        } catch (Error localError) {
            throw localError;
        } catch (Throwable localThrowable) {
            throw new UndeclaredThrowableException(localThrowable);
        }
    }

    static {
        try {
            m1 = Class.forName("java.lang.Object").getMethod("equals",
                    new Class[] { Class.forName("java.lang.Object") });
            m0 = Class.forName("java.lang.Object").getMethod("hashCode", new Class[0]);
            m3 = Class.forName("com.user.UserService").getMethod("addUser", new Class[0]);
            m2 = Class.forName("java.lang.Object").getMethod("toString", new Class[0]);
            //            return;
        } catch (NoSuchMethodException localNoSuchMethodException) {
            throw new NoSuchMethodError(localNoSuchMethodException.getMessage());
        } catch (ClassNotFoundException localClassNotFoundException) {
            throw new NoClassDefFoundError(localClassNotFoundException.getMessage());
        }
    }
}
