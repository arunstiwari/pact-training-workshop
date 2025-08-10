package com.kcb.pactproducer.model;

import lombok.Data;

import java.util.List;

@Data
public class ProductsResponse {
    private final List<Product> products;
}
