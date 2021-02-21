package org.example.projectorder.pattern.decorator;

import org.example.projectorder.details.Order;
import org.example.projectorder.details.OrsersParser;

public class ValidatorOrders extends DecoratorOrderprocess {

    OrsersParser parser = new OrsersParser();


    public ValidatorOrders(Orderprocess orderprocess) {
        super(orderprocess);
    }

    @Override
    public String action(Order order) {

        if (order.getName() != null&&order.getAddress()!=null) {
            System.out.println("Поля корректно заполнены");
        } else {
            System.out.println("Некорректно указаны поля - проверьте пожалуйста Ваш заказ");
        }
        return super.action(order);
    }

}
