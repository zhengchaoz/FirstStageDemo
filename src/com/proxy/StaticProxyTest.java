package com.proxy;

/**
 * @author
 * @date 2021-03-21-13:58
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        ClothFactory factory = new NikeClothFactory();
        ClothFactory clothFactory = new ProxyClothFactory(factory);
        clothFactory.produceCloth();
    }

}

interface ClothFactory {

    void produceCloth();

}

class NikeClothFactory implements ClothFactory {

    @Override
    public void produceCloth() {
        System.out.println("被代理的。");
    }
}

class ProxyClothFactory implements ClothFactory {

    private ClothFactory clothFactory;

    public ProxyClothFactory(ClothFactory clothFactory) {
        this.clothFactory = clothFactory;
    }

    @Override
    public void produceCloth() {
        clothFactory.produceCloth();
    }
}