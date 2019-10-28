package com.IceCoLa.Learn.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
/*
        使用：监听request————》ServletRequestListener接口监听创建和销毁
              监听request————》ServletRequestAttributeListener 接口监听request作用域数据变化
*/
public class MyListener implements ServletRequestListener, ServletRequestAttributeListener {
    //request销毁时
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }
    //request初始化时
    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {

    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {

    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {

    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {

    }
}
