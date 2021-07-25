package com.simpleapp.simpleapplication.repository;

import com.simpleapp.simpleapplication.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findByName(String name, Pageable pageable);
}
