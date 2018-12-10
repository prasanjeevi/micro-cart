package com.cloudnative.frontend;

import java.util.Date;
import java.util.UUID;

public class Order {
    String id;
    String productId;
    String userId;
    Date OrderedOn;

    public Order(String productId, String userId) {
        this.id = UUID.randomUUID().toString();
        this.productId = productId;
        this.userId = userId;
        this.OrderedOn = new Date();
    }

    public String getId() {
        return this.id;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getOrderedOn() {
        return this.OrderedOn;
    }
}