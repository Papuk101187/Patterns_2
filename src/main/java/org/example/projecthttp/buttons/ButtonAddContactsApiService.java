package org.example.projecthttp.buttons;

import org.example.projecthttp.details.Contact;
import org.example.projectorder.details.OrsersParser;
import org.example.projecthttp.menu.MenuItemApiService;
import org.example.projecthttp.service.ApiService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ButtonAddContactsApiService implements MenuItemApiService {


    ApiService service;
    OrsersParser orsersParser = new OrsersParser();

    public ButtonAddContactsApiService(ApiService orderServ) {
        service=orderServ;
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

        {
            System.out.println("FAZE № 1 ");
        }

        service.add(contact);

    }


    @Override
    public String getName() {
        return "Добавить контакт на сервер ";
    }


    @Override
    public boolean closeAfter() {
        return false;
    }



}
