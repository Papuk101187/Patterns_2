package org.example.projectorder.menu;
import org.example.projectorder.buttons.ButtonOrderPizza;
import org.example.projectorder.service.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MobAppOrderPizza {


    List<MenuItemOrderPizza> lists = new ArrayList();

    Service orderService;


    public MobAppOrderPizza(Service serviceOrders) throws IOException {
        this.orderService = serviceOrders;
        lists.add(new ButtonOrderPizza(orderService));
    }


    public void showMenu() throws IOException, InterruptedException {
        MenuOrderPizza menuOrderPizza = new MenuOrderPizza(lists);
        menuOrderPizza.starting();

    }


    public void runProgram() throws IOException, InterruptedException {
        while (true) {
            showMenu();
        }
    }


    public void start() throws IOException, InterruptedException {
        runProgram();
    }
}
