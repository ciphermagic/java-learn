package com.cipher.handler_demo.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Component;

/**
 * Bean工具类<br>
 * 在非spring管理的类中获取spring注册的bean
 *
 * @author cipher
 */
@Component
public class BeanTool extends ApplicationObjectSupport implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

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