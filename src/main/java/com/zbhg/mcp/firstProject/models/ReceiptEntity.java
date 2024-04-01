package com.zbhg.mcp.firstProject.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "Receipts")
public class ReceiptEntity<B> {
    @Id
    @Column(name = "ReceiptNo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int receiptNo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ReceiptDate")
    @CreationTimestamp
    private Date Date;

    @Column(name = "OrderId")
    private int orderId;

    @Column(name = "Amount")
    private int amount;

    public int getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(int receiptNo) {
        this.receiptNo = receiptNo;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        Date = date;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
