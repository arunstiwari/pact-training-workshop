package com.kcb.pactconsumer.model;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String name;
    private String type;
    private String version;
    private String code;
}
