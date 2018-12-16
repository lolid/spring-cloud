package com.xdclass.project_service.service.impl;

import com.xdclass.project_service.domain.Product;
import com.xdclass.project_service.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {


    private static final Map<Integer, Product> daoMap = new HashMap<>();

    static {
        Product p1 = new Product(1, "iphonex", 9999, 111);
        Product p2 = new Product(2, "冰箱", 2222, 10);
        Product p3 = new Product(3, "洗衣机", 3333, 33);
        Product p4 = new Product(4, "电话", 77777, 10);
        Product p5 = new Product(5, "汽车", 888, 10);


        daoMap.put(p1.getId(), p1);
        daoMap.put(p2.getId(), p2);
        daoMap.put(p3.getId(), p3);
        daoMap.put(p4.getId(), p4);
        daoMap.put(p5.getId(), p5);
    }


    @Override
    public List<Product> listProduct() {

        Collection<Product> collection = daoMap.values();
        List<Product> list = new ArrayList<>(collection);

        return list;
    }

    @Override
    public Product findById(int id) {
        return daoMap.get(id);
    }
}
