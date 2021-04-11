package com.mohammad.sales.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohammad.sales.model.Sales;

public interface SalesService extends JpaRepository<Sales, Integer> {

}
