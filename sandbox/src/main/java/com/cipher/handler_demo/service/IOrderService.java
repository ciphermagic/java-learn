package com.cipher.handler_demo.service;

import com.cipher.handler_demo.model.OrderDTO;

/**
 * @Author: CipherCui
 * @Description:
 * @Date: Created in 9:51 2019/2/2
 */
public interface IOrderService {

    /**
     * 根据订单的不同类型作出不同的处理
     *
     * @param dto 订单实体
     * @return 为了简单，返回字符串
     */
    String handle(OrderDTO dto);

}
