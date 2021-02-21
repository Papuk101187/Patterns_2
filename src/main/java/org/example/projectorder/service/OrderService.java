package org.example.projectorder.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.projectorder.details.Order;
import org.example.projectorder.pattern.chainofresponsibility.MessageHandler;
import org.example.projectorder.pattern.chainofresponsibility.OrderCheckMessageHandler;
import org.example.projectorder.pattern.chainofresponsibility.OrderOutputMessageHandler;
import org.example.projectorder.pattern.chainofresponsibility.OrderRecordMessageHandler;
import org.example.projectorder.pattern.decorator.*;

public class OrderService implements Service {

    MessageHandler handler =
            new OrderCheckMessageHandler(
                    new OrderOutputMessageHandler(
                            new OrderRecordMessageHandler(null))); // реализация паттерна
    // Chain of Responsibility


    Orderprocess orderprocess = new ValidatorOrders(
            new MessageOrderprocess(
                    new SaveOrderprocess(new PlugOrdeprocess())));// реализация паттерна
    // Decorator





    @Override
    public String action(Order order) throws JsonProcessingException {
        //handler.handle(order);
        orderprocess.action(order);
        return null;
    }





}
