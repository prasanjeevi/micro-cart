package com.cloudnative.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping( value = "/orders")
public class OrderController {

    private final MessageSender messageSender;

    @Autowired
    public OrderController(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String ping() {
        return "Pong";
    }

    @RequestMapping(method = RequestMethod.POST)
    public void order(@RequestBody Order order) {
        System.out.println("Received Order request");
        messageSender.Send(order);
        System.out.println("Order request sent to queue for processing");
    }

}
