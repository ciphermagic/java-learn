package com.cipher.handler_demo.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * Bean工具类<br>
 * 在非spring管理的类中获取spring注册的bean
 *
 * @author cipher
 */
@Component
public class BeanTool extends ApplicationObjectSupport implements ApplicationContextAware {

    static ApplicationContext context;
    private static ApplicationContext applicationContext = null;

    public static void setApplicationContext(WebApplicationContext applicationContext) {
        BeanTool.applicationContext = applicationContext;
    }

    public BeanTool getInstance() {
        return new BeanTool();
    }

    @Override
    protected void initApplicationContext(ApplicationContext context) {
        super.initApplicationContext(context);
        if (applicationContext == null) {
            applicationContext = context;
        }
    }

    public static ApplicationContext getAppContext() {
        return applicationContext;
    }

    public static Object getBean(String name) {
        return getAppContext().getBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        return getAppContext().getBean(clazz);
    }

}