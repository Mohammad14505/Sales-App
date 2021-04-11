package com.mohammad.sales.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohammad.sales.model.Product;

public interface ProductService extends JpaRepository<Product, Integer>{

}
