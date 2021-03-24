package com.debug;

/**
 * @author
 * @date 2021-03-22-17:25
 */
public class DebugTest extends  DebugTest1 {

    static {
        System.out.println("静态代码块");
    }

    {
        System.out.println("构造代码块");
    }

    public DebugTest() {
        System.out.println("构造方法");
    }

    public static void main(String[] args) {

        {
            System.out.println("普通代码块");
        }
        DebugTest debugTest = new DebugTest();
        System.out.println("普通");
    }

}

class DebugTest1 {

    static {
        System.out.println("父类静态代码块");
    }

    {
        System.out.println("父类构造代码块");
    }

    public DebugTest1() {
        System.out.println("父类构造方法");
    }

//    public static void main(String[] args) {
//        DebugTest debugTest = new DebugTest();
//
//        {
//            System.out.println("普通代码块");
//        }
//
//        System.out.println("普通");
//    }

}
