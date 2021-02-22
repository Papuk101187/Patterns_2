package org.example.projecthttp.buttons;

import org.example.projecthttp.details.Contact;
import org.example.projecthttp.menu.MenuItemApiService;
import org.example.projecthttp.service.ApiService;
import org.example.projectorder.details.OrsersParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ButtonpostAuthorized implements MenuItemApiService {


    ApiService service;
    OrsersParser orsersParser = new OrsersParser();

    public ButtonpostAuthorized(ApiService orderServ) {
        service = orderServ;
    }

    @Override
    public void doAction() throws IOException, InterruptedException {


        System.out.println("Введите type контакта [пример email]");
        BufferedReader t = new BufferedReader(new InputStreamReader(System.in)); //
        String type = t.readLine();
        System.out.println("Введите value контакта [пример vasia@i.ua]");
        BufferedReader v =new BufferedReader(new InputStreamReader(System.in)); //
        String value = v.readLine();
        System.out.println("Введите name контакта [пример vasia]");
        BufferedReader n = new BufferedReader(new InputStreamReader(System.in)); //
        String name = n.readLine();
        Contact contact = new Contact(type,value,name);

        service.postAuthorized(contact);

    }


    @Override
    public String getName() {
        return "postAuthorized (ДЛЯ ПРИМЕРА)";
    }


    @Override
    public boolean closeAfter() {
        return false;
    }


}
