package org.example.projectorder.pattern.chainofresponsibility;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OrderRecordMessageHandler extends MessageHandler {

    public OrderRecordMessageHandler(MessageHandler messageHandler) {
        super(messageHandler);
    }

    @Override
    public void handle(String order) throws JsonProcessingException {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Order book.txt", true))) {
            bw.write(order + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Заказ зафиксировали");
    }
}
