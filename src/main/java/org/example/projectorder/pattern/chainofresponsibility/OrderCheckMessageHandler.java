package org.example.projectorder.pattern.chainofresponsibility;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.projectorder.details.Order;
import org.example.projectorder.details.OrsersParser;

public class OrderCheckMessageHandler extends MessageHandler {

    OrsersParser parser = new OrsersParser();

    public OrderCheckMessageHandler(MessageHandler messageHandler) {

        super(messageHandler);
    }

    @Override
    public void handle(String order) throws JsonProcessingException {

        Order order1 = parser.deserializationСontact(order);
        if (order1.getName() != null&&order1.getAddress() !=null&&order1.getCount()>0) {
            System.out.println("Поля корректно заполнены");
            messageHandler.handle(order);
        } else {
            System.out.println("Некорректно указаны поля - проверьте пожалуйста Ваш заказ");
        }
    }
}
