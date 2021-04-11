package com.mohammad.sales.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohammad.sales.model.Log;

public interface LogService extends JpaRepository<Log,Integer> {

}
