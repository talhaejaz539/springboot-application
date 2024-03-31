package com.zbhg.mcp.firstProject.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SaleLineItemRepository extends JpaRepository<SaleLineItemEntity, Integer> {

}
