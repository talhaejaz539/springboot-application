package com.zbhg.mcp.firstProject.models;

import jakarta.persistence.*;

@Entity
@Table(name = "saleLineItems")
public class SaleLineItemEntity {

    @Id
    @Column(name = "LineNo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lineNo;

//    @ManyToOne(targetEntity = SaleEntity.class)
//    @JoinColumn(name = "OrderId")
    @Column(name = "OrderId")
    private int orderId;

//    @OneToOne(targetEntity = ItemEntity.class)
//    @JoinColumn(name = "ItemId")
    @Column(name = "ItemId")
    private int itemId;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "Amount")
    private int amount;

    public int getLineNo() {
        return lineNo;
    }

    public void setLineNo(int lineNo) {
        this.lineNo = lineNo;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {

        this.quantity = quantity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
