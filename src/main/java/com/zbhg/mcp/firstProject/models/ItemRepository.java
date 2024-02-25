package com.zbhg.mcp.firstProject.models;

import org.springframework.data.repository.CrudRepository;

import com.zbhg.mcp.firstProject.models.ItemEntity;

public interface ItemRepository extends CrudRepository<ItemEntity, Integer> {

}
