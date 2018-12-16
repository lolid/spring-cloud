package com.xdclass.project_service.service;

import com.xdclass.project_service.domain.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductService {

    List<Product> listProduct();

    Product findById(int id);
}
