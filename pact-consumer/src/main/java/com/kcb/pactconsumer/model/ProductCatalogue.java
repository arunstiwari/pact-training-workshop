package com.kcb.pactconsumer.model;

import lombok.Data;

import java.util.List;

@Data
public class ProductCatalogue {
    private final List<Product> products;
}
