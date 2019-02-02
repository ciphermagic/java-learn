package com.cipher.handler_demo.handler;

import com.google.common.collect.Maps;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: CipherCui
 * @Description: 使用 BeanPostProcessor 方式，不需指定扫描包
 * @Date: Created in 14:40 2019/2/1
 */
@Component
public class HandlerProcessorV2 implements BeanPostProcessor {

    private Map<String, Object> handlerMap = Maps.newHashMapWithExpectedSize(3);

    private boolean initHandlerContext = false;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        if (o.getClass().isAnnotationPresent(HandlerType.class)) {
            HandlerType handlerType = o.getClass().getAnnotation(HandlerType.class);
            String type = handlerType.value();
            handlerMap.put(type, o);
        }
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        if (!initHandlerContext) {
            DefaultListableBeanFactory beanFactory =  (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
            HandlerContext context = new HandlerContext(handlerMap);
            beanFactory.registerSingleton(HandlerContext.class.getName(), context);
            initHandlerContext = true;
        }
        return o;
    }

    /**
     * 处理器上下文，根据类型获取相应的处理器
     */
    public static class HandlerContext {
        private Map<String, Object> handlerMap;

        public HandlerContext(Map<String, Object> handlerMap) {
            this.handlerMap = handlerMap;
        }

        public AbstractHandler getInstance(Integer type) {
            Object obj = handlerMap.get(type);
            if (obj == null) {
                throw new IllegalArgumentException("not found handler for type: " + type);
            }
            return (AbstractHandler) obj;
        }
    }

}
