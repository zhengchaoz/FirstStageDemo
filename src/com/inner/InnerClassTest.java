package com.inner;

import org.junit.Test;

/**
 * @user Administrator
 * @date 2021/3/24
 */
public class InnerClassTest {

    @Test
    public void testInner() {
//        Outer.Inner inner = new Outer().new Inner();
//        inner.get();
//        System.out.println(inner.count);

//        new Outer().find();

//        Outer.Inner inner = new Outer().new Inner();
//        inner.study();

//        new Outer().getInner();

//        new Outer().new Inner3().play();

//        Outer.Inner3 inner3 = new Outer.Inner3();
//        inner3.play();

//        Outer.Inner3.play2();

//        new Outer().show();
    }

    @Test
    public void testInterInner() {
        Inner inner = new Inner() {

            @Override
            public Inner get() {
                System.out.println("我是get");
                return this;
            }

            @Override
            public Inner save() {
                System.out.println("我是save");
                return this;
            }
        }.get().save();

//        inner.get();
//        inner.save();
    }

    @Test
    public void testAbstractInner(){
        new Inner1() {
            @Override
            public Inner1 eat() {
                System.out.println("我是抽象的方法");
                return this;
            }
        }.play().eat();
    }
}

class Outer {

    String name;
    private int age;

    public void show() {
        class Inner {

            String name1;
            int age1;

            public void eat() {
                System.out.println("吃吃吃吃吃吃吃吃吃吃吃吃从");
            }

        }

        Inner inner = new Inner();
        System.out.println(inner.name1);
        System.out.println(inner.age1);
        inner.eat();
    }

    public void find() {
        System.out.println("外部类。。。。");
        System.out.println(new Inner().count);
//        System.out.println(new Inner().get());编译错误
    }

    public void getInner() {
        Inner1 inner1 = new Inner1();
        inner1.study();
    }

    class Inner {

        private int count = 10;

        public void get() {
            System.out.println("局部内部类：" + count);
            System.out.println("局部内部类：" + name);
            System.out.println("局部内部类：" + age);
            find();
        }

    }

    private class Inner1 {

        public void study() {
            System.out.println("局部内部类。。。 ");
        }

    }

    static class Inner3 {

        public void play() {
            System.out.println("呵呵哈哈哈或");
        }

        static public void play2() {
            System.out.println("阿斯达所大");
        }

    }

}

interface Inner {

    Inner get();

    Inner save();

}

abstract class Inner1 {

    abstract public Inner1 eat();

    public Inner1 play() {
        System.out.println("普通的方法");
        return this;
    }

}