package com.collection.list;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * @author
 * @date 2021-03-17-14:44
 */
public class EnumerationIterator implements Iterator {

    private Enumeration enumeration;

    public EnumerationIterator(Enumeration e) {
        enumeration = e;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public Object next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("暂不支持删除功能！");
    }

}
