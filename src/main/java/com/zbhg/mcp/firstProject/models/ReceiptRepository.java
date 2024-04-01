package com.zbhg.mcp.firstProject.models;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReceiptRepository extends CrudRepository<ReceiptEntity, Integer> {
    List<ReceiptEntity> findAllPaymentsByOrderId(Integer integer);
}
