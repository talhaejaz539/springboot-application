package com.zbhg.mcp.firstProject.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "sales")
public class SaleEntity {
    @Id
    @Column(name = "OrderId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

//    @ManyToOne(targetEntity = CustomerEntity.class)
//    @JoinColumn(name = "CustomerId")
    @Column(name = "CustomerId")
    private Integer customerId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Date")
    @CreationTimestamp
    private Date Date;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", columnDefinition = "VARCHAR(255) DEFAULT 'ACTIVE'")
    private Status status = Status.ACTIVE;

    public SaleEntity(int customerId) {
        setCustomerId(customerId);
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        Date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
