package com.kcb.pactconsumer.controller;

import com.kcb.pactconsumer.model.Product;
import com.kcb.pactconsumer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductCatalogueController {
    @Autowired
    ProductService productService;

    @GetMapping("/catalogue")
    public List<Product> catalogue(){
        List<Product> products = productService.fetchProducts();
        return products;
    }
}
