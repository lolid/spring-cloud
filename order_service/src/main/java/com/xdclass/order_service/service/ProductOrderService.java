package com.xdclass.order_service.service;

import com.xdclass.order_service.domain.ProductOrder;

/**
 * 订单业务类
 */
public interface ProductOrderService {
    /**
     * 下单业务
     * @param userId
     * @param productId
     * @return
     */
    ProductOrder save(int userId, int productId);
}
