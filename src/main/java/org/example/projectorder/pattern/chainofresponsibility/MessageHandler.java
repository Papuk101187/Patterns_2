package org.example.projectorder.pattern.chainofresponsibility;

import com.fasterxml.jackson.core.JsonProcessingException;

public abstract class MessageHandler {

    MessageHandler messageHandler;


    public MessageHandler(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }

    public abstract void handle(String ms) throws JsonProcessingException;

}
