package org.example.projecthttp.menu;

import org.example.projecthttp.buttons.ButtonGetContactsApiService;
import org.example.projecthttp.details.User;
import org.example.projecthttp.service.ApiService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MobAppApiService {

    List<MenuItemApiService> lists = new ArrayList();

    ApiService orderService;
    User user;


    public MobAppApiService(ApiService serviceOrders) throws IOException {
        this.orderService = serviceOrders;
        lists.add(new ButtonGetContactsApiService(orderService));
    }

    private void showMenu() throws IOException, InterruptedException {

        MenuApiService menuApiService = new MenuApiService(lists);
        menuApiService.starting();

    }


    private void runProgram() throws IOException, InterruptedException {
        while (true) {
            user = getDataUser();
            orderService.post(user);
            showMenu();
        }
    }

    private User getDataUser() throws IOException {

        System.out.println("Просим ввести данные аккаунта");
        String login;
        String password;
        String date;
        login = getLogin();
        password = getPassword();
        date = getDate();
        System.out.println("login " + login);
        System.out.println("password " + password);
        System.out.println("date " + date);

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setDate_born(date);
        return user;

    }

    private String getDate() throws IOException {
        System.out.println("Введите Вашу дату рождения в формате [yyyy-MM-dd] ");
        BufferedReader dat = new BufferedReader(new InputStreamReader(System.in));
        return dat.readLine();
    }

    private String getPassword() throws IOException {
        System.out.println("Введите password ");
        BufferedReader passw = new BufferedReader(new InputStreamReader(System.in)); //
        return passw.readLine();

    }

    private String getLogin() throws IOException {
        System.out.println("Введите login ");
        BufferedReader log = new BufferedReader(new InputStreamReader(System.in)); //
        return log.readLine();
    }


    public void start() throws IOException, InterruptedException {
        runProgram();
    }
}
