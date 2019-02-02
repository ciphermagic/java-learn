package com.cipher.handler_demo.handler;

import com.cipher.handler_demo.util.BeanTool;
import com.cipher.handler_demo.util.ClassScaner;
import com.google.common.collect.Maps;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 14:40 2019/2/1
 */
@Component
@SuppressWarnings("unchecked")
public class HandlerProcessor implements BeanFactoryPostProcessor {

    private static final String HANDLER_PACKAGE = "com.cipher.handler_demo.handler.biz";

    /**
     * 扫描@HandlerType，初始化HandlerContext，将其注册到spring容器
     *
     * @param beanFactory bean工厂
     * @see HandlerType
     * @see HandlerContext
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, Class> handlerMap = Maps.newHashMapWithExpectedSize(3);
        ClassScaner.scan(HANDLER_PACKAGE, HandlerType.class).forEach(clazz -> {
            String type = clazz.getAnnotation(HandlerType.class).value();
            handlerMap.put(type, clazz);
        });
        HandlerContext context = new HandlerContext(handlerMap);
        beanFactory.registerSingleton(HandlerContext.class.getName(), context);
    }

    /**
     * 处理器上下文，根据类型获取相应的处理器
     */
    public static class HandlerContext {
        private Map<String, Class> handlerMap;

        public HandlerContext(Map<String, Class> handlerMap) {
            this.handlerMap = handlerMap;
        }

        public AbstractHandler getInstance(String type) {
            Class clazz = handlerMap.get(type);
            if (clazz == null) {
                throw new IllegalArgumentException("not found handler for type: " + type);
            }
            return (AbstractHandler) BeanTool.getBean(clazz);
        }
    }

}
