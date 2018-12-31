package com.xdclass.order_service.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xdclass.order_service.service.ProductOrderService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    @Autowired
    private ProductOrderService productOrderService;

    @RequestMapping(value = "save")
    @HystrixCommand(fallbackMethod = "saveOrderFail")
    public Object save(@RequestParam("user_id")int userId, @RequestParam("product_id")int productId) {

        Map<String, Object> data = new HashMap<>();
        data.put("code", 0);
        data.put("data", productOrderService.save(userId, productId));
        return data;
    }

    //主要，方法签名呢一定要你和api方法一致
    private Object saveOrderFail(int userId, int productId) {

        //监控报警
        String saveOrderKey = "save-order";

        //String sendValue = redisTemplate.opsForValue().get(saveOrderKey);
        String sendValue = null;

        //新建线程 异步调用 ，可以使用线程池
        new Thread(() -> {
            if (StringUtils.isBlank(sendValue)) {
                System.out.println("紧急通知，用户下单失败，青立即查找原因");
                //发送 http 请求，调用短信服务 TODO
                //redisTemplate.opsForValue().set(saveOrderKey, "save-order-fail", 20, TimeUnit.SECONDS);
            } else {
                System.out.println("已经发送过短信，20 秒内不重新发送");
            }
        }).start();



        Map<String, Object> msg = new HashMap<>();
        msg.put("code", -1);
        msg.put("msg", "抢购的人数太多，您被挤出来了，请等待");
        return  msg;
    }

}
