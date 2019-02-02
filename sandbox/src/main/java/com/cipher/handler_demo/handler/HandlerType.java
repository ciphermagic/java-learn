package com.cipher.handler_demo.handler;

import java.lang.annotation.*;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 10:07 2019/2/2
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface HandlerType {

    String value();

}
