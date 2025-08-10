package com.kcb.pactconsumer;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.PactSpecVersion;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import com.kcb.pactconsumer.model.Product;
import com.kcb.pactconsumer.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@SpringBootTest
@ExtendWith(PactConsumerTestExt.class)
@PactTestFor(providerName = "KCBProductService")
class PactConsumerApplicationTests {

    @Autowired
    private ProductService productService;

    @Pact(consumer = "KCBProductConsumer")
    public RequestResponsePact allProducts(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        return builder.given("all_product_exists")
                .uponReceiving("fetch all products")
                .path("/products")
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body(
                        new PactDslJsonBody()
                                .minArrayLike("products",1,1)
                                .integerType("id", 1L)
                                .stringType("name", "Product_1")
                                .stringMatcher("type", "cosmetics")
                                .closeObject()
                                .closeArray()
                ).toPact();
    }

    @Test
    @PactTestFor(pactMethod = "allProducts", pactVersion = PactSpecVersion.V1)
    void testAllProducts(MockServer mockServer) {
        productService.setProductServiceUrl(mockServer.getUrl());
        List<Product> products = productService.fetchProducts();
        assertThat(products, hasSize(1));
        assertThat(products.get(0).getName(), is(equalTo("Product_1")));
    }

}
