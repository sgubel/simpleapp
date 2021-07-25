package com.simpleapp.simpleapplication.service;

import com.simpleapp.simpleapplication.entity.Product;
import com.simpleapp.simpleapplication.exception.NotFoundException;
import com.simpleapp.simpleapplication.repository.ProductRepository;
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
       return productRepository.save(product);
    }

    public Product findById(int id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    public void delete(int id) {
        productRepository.deleteById(id);
    }

    public Page<Product> getProducts(String name, Pageable pageable) {
        return name == null ? productRepository.findAll(pageable) : productRepository.findByName(name, pageable);
    }

}
