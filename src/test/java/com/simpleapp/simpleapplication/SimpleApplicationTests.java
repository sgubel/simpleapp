package com.simpleapp.simpleapplication;

import com.simpleapp.simpleapplication.entity.Product;
import com.simpleapp.simpleapplication.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SimpleApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    void testCreateProduct() {
        Product product = new Product();
        product.setName("test product");
        product.setDescription("description of test product");
        product.setWeight(5.0);
        product.setPrice(100.0);
        product.setCountry("USA");
        productService.save(product);

        Product product1 = productService.findById(product.getId());

        assertEquals(product1.getId(), product.getId());
        assertEquals(product1.getDescription(), product.getDescription());
        assertEquals(product1.getCountry(), product.getCountry());
    }

    @Test
    void testFindById() {
        Product product = productService.findById(1);
        assertEquals("test product", product.getName());
    }

    @Test
    void testUpdate() {
        Product product = productService.findById(1);
        product.setDescription("description updated");
        productService.update(1, product);
        assertEquals("description updated", productService.findById(1).getDescription());
    }

}
