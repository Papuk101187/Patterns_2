package org.example.projecthttp.buttons;
import org.example.projectorder.details.OrsersParser;
import org.example.projecthttp.menu.MenuItemApiService;

import org.example.projecthttp.service.ApiService;

import java.io.IOException;

public class ButtonGet implements MenuItemApiService {


    ApiService service;
    OrsersParser orsersParser = new OrsersParser();

    public ButtonGet(ApiService orderServ) {
        service = orderServ;
    }

    @Override
    public void doAction() throws IOException, InterruptedException {


        service.get();

    }


    @Override
    public String getName() {
        return "get (ДЛЯ ПРИМЕРА)";
    }


    @Override
    public boolean closeAfter() {
        return false;
    }


}
