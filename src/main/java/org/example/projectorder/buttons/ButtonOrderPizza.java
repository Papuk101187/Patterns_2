package org.example.projectorder.buttons;

import org.example.projectorder.details.Order;
import org.example.projectorder.details.OrsersParser;
import org.example.projectorder.menu.MenuItemOrderPizza;
import org.example.projectorder.service.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ButtonOrderPizza implements MenuItemOrderPizza {


    Service service;
    OrsersParser orsersParser = new OrsersParser();

    public ButtonOrderPizza(Service orderServ) {
        service=orderServ;
    }

    @Override
    public void doAction() throws IOException, InterruptedException {

        System.out.println("Введите название пиццы");
        BufferedReader t = new BufferedReader(new InputStreamReader(System.in)); //
        String type = t.readLine();
        System.out.println("Введите желаемое количество");
        BufferedReader v =new BufferedReader(new InputStreamReader(System.in)); //
        int count = Integer.parseInt(v.readLine());
        System.out.println("Введите адрес доставки");
        BufferedReader n = new BufferedReader(new InputStreamReader(System.in)); //
        String name = n.readLine();
        Order order = new Order(type,count,name);
        String sp = orsersParser.deserializationСontact(order);

        String status = service.action(order);

        }


    @Override
    public String getName() {
        return "Заказать пиццу  ";
    }


    @Override
    public boolean closeAfter() {
        return false;
    }



}
