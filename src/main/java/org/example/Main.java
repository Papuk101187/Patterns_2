package org.example;

import org.example.projecthttp.details.User;
import org.example.projecthttp.menu.MobAppApiService;
import org.example.projecthttp.service.ApiService;
import org.example.projecthttp.service.ConactApiService;
import org.example.projectorder.menu.MobAppOrderPizza;
import org.example.projectorder.service.OrderService;
import org.example.projectorder.service.Service;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {


      //Service service = new OrderService(); //  Chain of Responsibility , Decorator
        //MobAppOrderPizza mobAppOrderPizza = new MobAppOrderPizza(service);
        //mobAppOrderPizza.start();


        ApiService service1 = new ConactApiService(new User());   // Facade
        MobAppApiService menuItemApiService = new MobAppApiService(service1);
        menuItemApiService.start();


    }

}
