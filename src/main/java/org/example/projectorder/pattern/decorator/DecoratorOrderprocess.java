package org.example.projectorder.pattern.decorator;

import org.example.projectorder.details.Order;

public class DecoratorOrderprocess implements Orderprocess {

    Orderprocess orderprocess;

    public DecoratorOrderprocess(Orderprocess orderprocess) {
        this.orderprocess = orderprocess;
    }

    @Override
    public String action(Order order) {
        return orderprocess.action(order);

    }

}
