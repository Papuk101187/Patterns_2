package org.example.projecthttp.buttons;
import org.example.projecthttp.details.ContactsResponse;
import org.example.projectorder.details.OrsersParser;
import org.example.projecthttp.menu.MenuItemApiService;

import org.example.projecthttp.service.ApiService;

import java.io.IOException;

public class ButtonGetContactsApiService implements MenuItemApiService {


    ApiService service;
    OrsersParser orsersParser = new OrsersParser();

    public ButtonGetContactsApiService(ApiService orderServ) {
        service=orderServ;
    }

    @Override
    public void doAction() throws IOException, InterruptedException {


        ContactsResponse userResponse = service.get();



        }


    @Override
    public String getName() {
        return "Получить контакты из сервера ";
    }


    @Override
    public boolean closeAfter() {
        return false;
    }



}
