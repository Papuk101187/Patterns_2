package org.example.projectorder.pattern.decorator;

import org.example.projectorder.details.Order;
import org.example.projectorder.details.OrsersParser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MessageOrderprocess extends DecoratorOrderprocess {

    public MessageOrderprocess(Orderprocess orderprocess) {
        super(orderprocess);
    }

    @Override
    public String action(Order orsers) {

        OrsersParser orsersParser = new OrsersParser();
        String ors = orsersParser.deserializationСontact(orsers);



        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Order book.txt", true))) {
            System.out.println("OrderRecordMessageHandler.handle --- " + ors);
            bw.write(ors + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Записали");

        return super.action(orsers);
    }


}
