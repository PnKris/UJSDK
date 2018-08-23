package com.ujia.ujsdk;

import android.util.SparseArray;

import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements Serializable {

    public static <T> T newProxy(Class<T> t, T o) {
        Handler handler = new Handler(o.hashCode());
        T proxyInstance = (T) Proxy.newProxyInstance(o.getClass().getClassLoader(), new Class[]{t}, handler);
        ProxyStore.proxyArray.put(o.hashCode(), new WeakReference<Object>(o));
        return proxyInstance;
    }

    private static class Handler implements InvocationHandler, Serializable {
        int proxyId;

        Handler(int proxyId) {
            this.proxyId = proxyId;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, args);
            }

            if (ProxyStore.proxyArray.get(proxyId) == null) {
                return null;
            }
            return method.invoke(ProxyStore.proxyArray.get(proxyId).get(), args);
        }
    }

    private static class ProxyStore {
        private static SparseArray<WeakReference<Object>> proxyArray = new SparseArray<>();
    }
}
