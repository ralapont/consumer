package com.example.demo.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

}
