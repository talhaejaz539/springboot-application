package com.zbhg.mcp.firstProject.models;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class CustomerEntity {
    @Id
    @Column(name = "CustomerId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Address")
    private String address;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Email")
    private String email;

    @Column(name = "AmountPayable")
    private int amountPayable;

    @Column(name = "SalesLimit")
    private int salesLimit;

    public CustomerEntity() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(int amountPayable) {
        this.amountPayable = amountPayable;
    }

    public int getSalesLimit() {
        return salesLimit;
    }

    public void setSalesLimit(int salesLimit) {
        this.salesLimit = salesLimit;
    }
}
