package com.zbhg.mcp.firstProject.controllers;

import com.zbhg.mcp.firstProject.models.CustomerEntity;
import com.zbhg.mcp.firstProject.models.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping(path = "/addCustomer")
    public @ResponseBody CustomerEntity addCustomer(@RequestBody CustomerEntity customer) {
        return customerRepository.save(customer);
    }

    @GetMapping(path = "/allCustomers")
    public @ResponseBody Iterable<CustomerEntity> allCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping(path = "/findCustomerById")
    public @ResponseBody Optional<CustomerEntity> findCustomerById(@RequestParam int id) {
        return customerRepository.findById(id);
    }

    @PutMapping(path = "/updateCustomerById")
    public @ResponseBody String updateCustomerById(@RequestParam int id, @RequestBody CustomerEntity customer) {

        Optional<CustomerEntity> optionalCustomer = customerRepository.findById(id);

        if(optionalCustomer.isPresent()) {
            CustomerEntity existingCustomer = optionalCustomer.get();
            existingCustomer.setName(customer.getName());
            existingCustomer.setAddress(customer.getAddress());
            existingCustomer.setPhone(customer.getPhone());
            existingCustomer.setEmail(customer.getEmail());
            existingCustomer.setSalesLimit(customer.getSalesLimit());
            customerRepository.save(existingCustomer);
        } else {
            return "Customer does not exist";
        }

        return "Customer Updated";
    }

    @DeleteMapping(path = "/deleteCustomerById")
    public @ResponseBody String deleteCustomerById(@RequestParam int id) {
        if(customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        } else {
            return "Customer does not exist";
        }
        return "Customer Deleted";
    }
}
