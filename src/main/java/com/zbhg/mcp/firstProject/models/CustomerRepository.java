package com.zbhg.mcp.firstProject.models;

import org.springframework.data.repository.CrudRepository;

import com.zbhg.mcp.firstProject.models.CustomerRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {
}
