package com.kcb.pactconsumer.service;

import com.kcb.pactconsumer.model.Product;
import com.kcb.pactconsumer.model.ProductCatalogue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${service.productService.url}")
    private String productServiceUrl;

//    public List<Product> fetchProducts() {
//        ResponseEntity<List<Product>> response = restTemplate.exchange(
//                productServiceUrl + "/products",
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<Product>>() {}
//        );
//        return response.getBody();
//    }

    public List<Product> fetchProducts() {
       ProductCatalogue catalogue = restTemplate.getForObject(productServiceUrl+"/products", ProductCatalogue.class);
       return catalogue.getProducts();
    }

    public Product fetchProductById(Long id){
        return restTemplate.getForObject(productServiceUrl + "/products/" + id, Product.class);
    }

    public void setProductServiceUrl(String productServiceUrl) {
        this.productServiceUrl = productServiceUrl;
    }
}
