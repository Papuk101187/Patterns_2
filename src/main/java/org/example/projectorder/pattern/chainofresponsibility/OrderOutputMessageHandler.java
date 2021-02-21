package org.example.projectorder.pattern.chainofresponsibility;

import com.fasterxml.jackson.core.JsonProcessingException;

public class OrderOutputMessageHandler extends MessageHandler {

    public OrderOutputMessageHandler(MessageHandler messageHandler) {
        super(messageHandler);
    }

    @Override
    public void handle(String order) throws JsonProcessingException {
        System.out.println("Заказ  "+order+" "+" сформирован");
        messageHandler.handle(order);
    }
}
