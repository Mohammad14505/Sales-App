package com.mohammad.sales.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohammad.sales.model.Clients;

public interface ClientService extends JpaRepository<Clients,Integer> {

}
