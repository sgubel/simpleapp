package com.simpleapp.simpleapplication.service;

import com.simpleapp.simpleapplication.entity.ProductEntity;
import com.simpleapp.simpleapplication.exception.NotFoundException;
import com.simpleapp.simpleapplication.model.Product;
import com.simpleapp.simpleapplication.repository.ProductRepository;
import com.simpleapp.simpleapplication.utils.ConverterUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(Product product) {
        return save(product);
    }

    public Product update(int id, Product product) {
        Product storedProduct = findById(id);
        storedProduct.setName(product.getName());
        storedProduct.setDescription(product.getDescription());
        storedProduct.setPrice(product.getPrice());
        storedProduct.setWeight(product.getWeight());
        storedProduct.setCountry(product.getCountry());
        return save(storedProduct);
    }

    public Product save(Product product) {
       return ConverterUtils.convert(productRepository.save(ConverterUtils.convert(product)));
    }

    public Product findById(int id) {
        ProductEntity productEntity = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
        return ConverterUtils.convert(productEntity);
    }

    public void delete(int id) {
        productRepository.deleteById(id);
    }

    public Page<Product> getProducts(String name, Pageable pageable) {
        Page<ProductEntity> productPage = name == null ? productRepository.findAll(pageable) :
                productRepository.findByName(name, pageable);
        productPage.map(ConverterUtils::convert);
        return productPage.map(ConverterUtils::convert);
    }

}
