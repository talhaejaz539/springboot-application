package com.zbhg.mcp.firstProject.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SaleLineItemRepository extends JpaRepository<SaleLineItemEntity, Integer> {

    List<SaleLineItemEntity> findAllByOrderId(Integer integer);
}
