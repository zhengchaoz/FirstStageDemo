package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author
 * @date 2021-03-21-14:07
 */
public class ProxyTest {

    public static void main(String[] args) {
        Human superMan = new SuperMan();
        Human human = (Human) ProxyFactory.getProxyInstance(superMan);
        System.out.println(human.getBelief());
        human.eat("鱼");

        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory proxyInstance = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
        proxyInstance.produceCloth();
    }

}

interface Human {

    String getBelief();

    void eat(String food);

}

class SuperMan implements Human {

    @Override
    public String getBelief() {
        return "氪星";
    }

    @Override
    public void eat(String food) {
        System.out.println("吃氪石" + food);
    }
}

class HumanUtil {

    public void method1() {
        System.out.println("1");
    }

    public void method2() {
        System.out.println("2");
    }

}

class ProxyFactory {

    public static Object getProxyInstance(Object o) {
        MyInvocationHandler my = new MyInvocationHandler();
        my.bind(o);
        return Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), my);
    }

}

class MyInvocationHandler implements InvocationHandler {

    private Object o;

    public void bind(Object o) {
        this.o = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        new HumanUtil().method1();
        return method.invoke(o, args);
    }

}