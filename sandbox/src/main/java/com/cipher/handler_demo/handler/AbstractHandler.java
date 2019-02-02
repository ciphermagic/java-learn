package com.cipher.handler_demo.handler;

import com.cipher.handler_demo.model.OrderDTO;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 13:57 2019/2/1
 */
public abstract class AbstractHandler {

    abstract public String handle(OrderDTO dto);

}
