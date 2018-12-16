package com.xdclass.project_service.controller;

import com.xdclass.project_service.domain.Product;
import com.xdclass.project_service.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Value ("${server.port}")
    private String port;

    @Autowired
    private ProductService productService;

    /**
     * 商品列表
     * @return
     */
    @GetMapping("list")
    public Object list() {
        return productService.listProduct();
    }

    /**
     * 单个商品
     * @param id
     * @return
     */
    @GetMapping("find")
    public Object findById(@RequestParam int id) {

        Product product = productService.findById(id);
        Product result = new Product();
        BeanUtils.copyProperties(product, result);
        result.setName(result.getName()+" data from port: " + port);

        return result;
    }
}
