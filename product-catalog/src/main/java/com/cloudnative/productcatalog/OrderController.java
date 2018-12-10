package com.cloudnative.productcatalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping( value = "/orders")
public class OrderController {

    OrderRepository repository;

    @Autowired
    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Order> get() {
        return repository.findAll();
    }

    @RequestMapping(value = "recent", method = RequestMethod.GET)
    public Iterable<Order> recentOrders() {
        return repository.recentOrders();
    }
    
}