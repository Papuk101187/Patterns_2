package org.example.projecthttp.buttons;

import org.example.projecthttp.menu.MenuItemApiService;
import org.example.projecthttp.service.ApiService;
import org.example.projectorder.details.OrsersParser;

import java.io.IOException;

public class ButtonGetAuthorized implements MenuItemApiService {


    ApiService service;
    OrsersParser orsersParser = new OrsersParser();

    public ButtonGetAuthorized(ApiService orderServ) {
        service = orderServ;
    }

    @Override
    public void doAction() throws IOException, InterruptedException {


        service.getAuthorized();

    }


    @Override
    public String getName() {
        return "get Authorized (ДЛЯ ПРИМЕРА)";
    }


    @Override
    public boolean closeAfter() {
        return false;
    }


}
