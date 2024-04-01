package com.zbhg.mcp.firstProject.controllers;

import com.zbhg.mcp.firstProject.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class ReceiptController {
    @Autowired
    private ReceiptRepository receiptRepository;
    @Autowired
    private SaleLineItemRepository saleLineItemRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping(path = "/makePayment")
    public ResponseEntity<ReceiptEntity> makePayment(@RequestParam int customerId, @RequestParam int orderId, @RequestBody Map<String, Integer> requestBody) {
        // Get Payment Against OrderId
        int paymentAmount = requestBody.get("paymentAmount");

        int remainingAmount = totalAmountOfSale(orderId) - paidAmountOfSale(orderId);
        ReceiptEntity receiptEntity = new ReceiptEntity();

        if(paymentAmount <= remainingAmount) {
            receiptEntity.setOrderId(orderId);
            receiptEntity.setAmount(paymentAmount);
            receiptEntity = receiptRepository.save(receiptEntity);

            Optional<CustomerEntity> optionalCustomer = customerRepository.findById(customerId);
            if(optionalCustomer.isPresent()) {
                CustomerEntity existingCustomer = optionalCustomer.get();
                existingCustomer.setAmountPayable(existingCustomer.getAmountPayable() - paymentAmount);
                customerRepository.save(existingCustomer);
            }
        }

        return ResponseEntity.ok(receiptEntity);
    }

    @GetMapping(path = "/totalAmountOfSale")
    public Integer totalAmountOfSale(@RequestParam int oderId) {
        List<SaleLineItemEntity> saleRecords = saleLineItemRepository.findAllByOrderId(oderId);

        if(null == saleRecords)
            return -1;

        int totalAmountOfSale = 0;
        for(SaleLineItemEntity saleRecord : saleRecords) {
            totalAmountOfSale += saleRecord.getAmount();
        }

        return totalAmountOfSale;
    }

    @GetMapping(path = "/paidAmountOfSale")
    public Integer paidAmountOfSale(@RequestParam int oderId) {
        List<ReceiptEntity> receiptRecords = receiptRepository.findAllPaymentsByOrderId(oderId);

        if(null == receiptRecords)
            return -1;

        int paidAmountOfSale = 0;
        for(ReceiptEntity receiptRecord : receiptRecords) {
            paidAmountOfSale += receiptRecord.getAmount();
        }

        return paidAmountOfSale;
    }
}
