package org.example.projectorder.pattern.decorator;

import org.example.projectorder.details.Order;

public class PlugOrdeprocess implements Orderprocess {

    @Override
    public String action(Order order) {

        return "Действие выполнено ";
    }

}
