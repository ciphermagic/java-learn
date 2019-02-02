package com.cipher.handler_demo.service.impl;

import com.cipher.handler_demo.handler.AbstractHandler;
import com.cipher.handler_demo.handler.HandlerContext;
import com.cipher.handler_demo.model.OrderDTO;
import com.cipher.handler_demo.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 9:54 2019/2/2
 */
@Service
public class OrderServiceV2Impl implements IOrderService {

    @Autowired
    private HandlerContext handlerContext;

    @Override
    public String handle(OrderDTO dto) {
        AbstractHandler handler = handlerContext.getInstance(dto.getType());
        return handler.handle(dto);
    }

}
