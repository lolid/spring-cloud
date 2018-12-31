package com.xdclass.order_service.fallback;

import com.xdclass.order_service.service.ProductClient;
import org.springframework.stereotype.Component;

/**
 * 商品服务客户端，针对商品服务做降级处理
 */
@Component
public class ProductClientFallback implements ProductClient {
    @Override
    public String findById(int id) {
        System.out.println("feign 调用 product-service 异常");
        return null;
    }
}
