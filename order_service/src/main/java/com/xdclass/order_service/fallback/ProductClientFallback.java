package com.xdclass.order_service.fallback;

import com.xdclass.order_service.service.ProductClient;
import org.springframework.stereotype.Component;

/**
 * 商品服务客户端
 */
@Component
public class ProductClientFallback implements ProductClient {
    @Override
    public String findById(int id) {
        return null;
    }
}
