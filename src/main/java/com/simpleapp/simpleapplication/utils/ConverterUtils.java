package com.simpleapp.simpleapplication.utils;

import com.simpleapp.simpleapplication.entity.ProductEntity;
import com.simpleapp.simpleapplication.model.Product;
import com.simpleapp.simpleapplication.model.form.ProductForm;

public final class ConverterUtils {

    private ConverterUtils() {
    }

    public static Product convert(ProductEntity productEntity) {
        Product product = new Product();
        product.setId(productEntity.getId());
        product.setName(productEntity.getName());
        product.setDescription(productEntity.getDescription());
        product.setPrice(productEntity.getPrice());
        product.setWeight(productEntity.getWeight());
        product.setCountry(productEntity.getCountry());

        return product;
    }

    public static Product convert(ProductForm productForm) {
        Product product = new Product();
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        product.setPrice(productForm.getPrice());
        product.setWeight(productForm.getWeight());
        product.setCountry(productForm.getCountry());

        return product;
    }

    public static ProductEntity convert(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(product.getId());
        productEntity.setName(product.getName());
        productEntity.setDescription(product.getDescription());
        productEntity.setPrice(product.getPrice());
        productEntity.setWeight(product.getWeight());
        productEntity.setCountry(product.getCountry());

        return productEntity;
    }

}
