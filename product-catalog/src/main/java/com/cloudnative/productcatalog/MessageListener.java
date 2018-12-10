package com.cloudnative.productcatalog;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.cache.CacheManager;

@Component
public class MessageListener {

    @Autowired
    private CacheManager cacheManager;

    OrderRepository repository;

    @Autowired
    public MessageListener(OrderRepository repository) {
        this.repository = repository;
    }

    @RabbitListener(queues = RabbitConfig.QUEUE_ORDERS)
    public void process(Order order) {
        System.out.println("Read Order request from queue");
        this.repository.save(order);
        cacheManager.getCache("products-top").clear();
        cacheManager.getCache("products-recent").clear();
    }
}