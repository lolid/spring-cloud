package com.xdclass.order_service.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.xdclass.order_service.domain.ProductOrder;
import com.xdclass.order_service.service.ProductOrderService;
import com.xdclass.order_service.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class ProductOrderImpl implements ProductOrderService {


//    @Autowired
//    private RestTemplate restTemplate;


    /**
     * 注入 productClient
     */
    @Autowired
    private ProductClient productClient;

    /**
     * 下单业务
     *
     * @param userId
     * @param productId
     * @return
     */
    @Override
    public ProductOrder save(int userId, int productId) {
        //获取商品详情 TODO
        //Map<String, Object> prodcutMap = restTemplate.getForObject("http://product-service/api/v1/product/find?id=" + productId, Map.class);

        //使用方式二。替代LoadBalance
//        ServiceInstance instance = loadBalancer.choose("product-service");
//
//        String url = String.format("http://%s:@s/api/v1/product/find?id=" + productId, instance.getHost(), instance.getPort());
//        Map<String, Object> productMap = restTemplate.getForObject(url, Map.class);




        String response = productClient.findById(productId);

        //转成jsonNode
        JsonNode jsonNode = JsonUtils.str2JsonNode(response);



        ProductOrder productOrder = new ProductOrder();
        productOrder.setCreateTime(new Date());
        productOrder.setUsesrId(userId);
        productOrder.setTradeNo(UUID.randomUUID().toString());
        productOrder.setProductName(jsonNode.get("name").toString());
        productOrder.setPrice(Integer.parseInt(jsonNode.get("price").toString()));

        return productOrder;
    }
}
