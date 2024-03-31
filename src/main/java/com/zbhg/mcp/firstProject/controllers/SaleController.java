package com.zbhg.mcp.firstProject.controllers;

import com.zbhg.mcp.firstProject.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SaleController {

    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private SaleLineItemRepository saleLineItemRepository;

    @PostMapping(path = "/addSale")
    public ResponseEntity<Boolean> addSale(@RequestParam int customerId, @RequestBody List<ItemEntity> items) {

        // Make a Sale & get OrderId
        int orderId = getOrderIdAfterSale(customerId);

        // Persist Items in DB of Sale & Update Quantity
        int amountPayableOfSale = saleLineItemsAndUpdateItemsQuantity(orderId, items);

        // Update Customer Amount Payable
        boolean statusAfterUpdatingPayableAmount = getStatusAfterUpdatingPayableAmount(customerId, amountPayableOfSale);

        return ResponseEntity.ok(statusAfterUpdatingPayableAmount);
    }

    private int getOrderIdAfterSale(int customerId) {
        SaleEntity saleEntity = new SaleEntity(customerId);
        saleEntity = saleRepository.save(saleEntity);
        return saleEntity.getOrderId();
    }

    private int saleLineItemsAndUpdateItemsQuantity(int orderId, List<ItemEntity> items) {
        int amountpayable = 0;
        for (ItemEntity item : items) {
            Optional<ItemEntity> optionalItem = itemRepository.findById(item.getItemId());

            if(optionalItem.isPresent()) {
                ItemEntity existingItem = optionalItem.get();
                existingItem.setQuantity(existingItem.getQuantity() - item.getQuantity());
                itemRepository.save(existingItem);

                int tempAmount = item.getQuantity() * item.getPrice();

                SaleLineItemEntity saleLineItemEntity = new SaleLineItemEntity();
                saleLineItemEntity.setOrderId(orderId);
                saleLineItemEntity.setItemId(item.getItemId());
                saleLineItemEntity.setQuantity(item.getQuantity());
                saleLineItemEntity.setAmount(tempAmount);
                saleLineItemRepository.save(saleLineItemEntity);
                amountpayable += tempAmount;
            }
        }
        return amountpayable;
    }

    private boolean getStatusAfterUpdatingPayableAmount(int customerId, int amountPayableOfSale) {
        Optional<CustomerEntity> optionalCustomer = customerRepository.findById(customerId);
        if(optionalCustomer.isPresent()) {
            CustomerEntity existingCustomer = optionalCustomer.get();
            existingCustomer.setAmountPayable(existingCustomer.getAmountPayable() + amountPayableOfSale);
            customerRepository.save(existingCustomer);
            return true;
        }
        return false;
    }

//    @GetMapping(path = "/sale")
//    public @ResponseBody String sale() {
//        return "Talha";
//    }

}
