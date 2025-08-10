package com.kcb.pactproducer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public ProductsResponse products() {
        log.info("Returning all products");
        return new ProductsResponse(StreamSupport.stream(productRepository.findAll().spliterator(), false).collect(Collectors.toList()));
    }

    @GetMapping("/product/{id}")
    public Product productById(@PathVariable Long id) {
        log.info("Returning product by id: {}", id);
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found"));
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class ProductNotFoundException extends RuntimeException {
        public ProductNotFoundException(String message) {
            super(message);
        }
    }

}
