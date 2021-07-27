package com.simpleapp.simpleapplication.controller;

import com.simpleapp.simpleapplication.model.Product;
import com.simpleapp.simpleapplication.model.form.ProductForm;
import com.simpleapp.simpleapplication.service.ProductService;
import com.simpleapp.simpleapplication.utils.ConverterUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProductForm form) {
        Product createdProduct = productService.create(ConverterUtils.convert(form));
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdProduct.getId()).toUri();
        return ResponseEntity.created(location).body(createdProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody ProductForm form) {
        return ResponseEntity.ok().body(productService.update(id, ConverterUtils.convert(form)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        return ResponseEntity.ok().body(productService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<?> list(@RequestParam(value = "name", required = false) String name,
                                  @PageableDefault Pageable pageable) {
        return ResponseEntity.ok().body(productService.getProducts(name, pageable));
    }

}
